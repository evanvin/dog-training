package com.haywood.dog.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.haywood.dog.config.HaywoodConstants;
import com.haywood.dog.config.SpringMongoConfig;
import com.haywood.dog.dao.Customer;
import com.haywood.dog.forms.CustomerForm;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class CustomerService extends GenericService {

	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(CustomerService.class);

	ApplicationContext ctx = new AnnotationConfigApplicationContext(
			SpringMongoConfig.class);
	MongoOperations mongoOperation = (MongoOperations) ctx
			.getBean("mongoTemplate");

	public List<Customer> getAllActiveCustomers() {
		logger.debug(">>> getAllActiveCustomers:ENTERED");
		Query query = new Query(Criteria.where("isActive").is(true));
		logger.debug(">>> getAllActiveCustomers:EXITED");
		return mongoOperation.find(query, Customer.class);
	}

	public Customer convertFormToCustomer(CustomerForm form) {
		Customer customer = null;

		if (form.getId() != null && !form.getId().equals("")) {
			customer = findCustomer(form.getId());
		} else {
			customer = new Customer();
			customer.setId(null);
		}
		customer.setFirstName(form.getFirstName());
		customer.setLastName(form.getLastName());
		customer.setPetName(form.getPetName());
		customer.setEmail(form.getEmail());
		customer.setPhone(form.getPhone());
		customer.setAddressOne(nullCheck(form.getAddressOne()));
		customer.setAddressTwo(nullCheck(form.getAddressTwo()));
		customer.setCity(nullCheck(form.getCity()));
		customer.setZip(nullCheck(form.getZip()));
		customer.setState(nullCheck(form.getState()));
		customer.setPetDOB(nullCheck(form.getPetDOB()));
		customer.setPetDesc(nullCheck(form.getPetDesc()));
		customer.setNotes(nullCheck(form.getNotes()));
		customer.setService(nullCheck(form.getService()));
		return customer;
	}

	public void saveOrUpdateCustomer(Customer customer) {
		logger.debug(">>> saveOrUpdateCustomer:ENTERED Customer has id = "
				+ customer.getId());
		mongoOperation.save(customer);
	}

	public void deactivateCustomer(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoOperation.updateFirst(query, Update.update("isActive", false),
				Customer.class);
	}

	public Customer findCustomer(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		return mongoOperation.findOne(query, Customer.class);
	}

	public CustomerForm getCustomerFormFromCustomer(String id) {
		CustomerForm form = new CustomerForm();
		Customer c = findCustomer(id);
		form.setFirstName(c.getFirstName());
		form.setLastName(c.getLastName());
		form.setPetName(c.getPetName());
		form.setEmail(c.getEmail());
		form.setPhone(c.getPhone());
		form.setAddressOne(nullCheck(c.getAddressOne()));
		form.setAddressTwo(nullCheck(c.getAddressTwo()));
		form.setCity(nullCheck(c.getCity()));
		form.setZip(nullCheck(c.getZip()));
		form.setState(nullCheck(c.getState()));
		form.setPetDOB(nullCheck(c.getPetDOB()));
		form.setPetDesc(nullCheck(c.getPetDesc()));
		form.setNotes(nullCheck(c.getNotes()));
		form.setService(nullCheck(c.getService()));
		form.setId(c.getId());
		return form;
	}

	public void graduateCustomer(String id) {
		Query query = new Query(Criteria.where("id").is(id));
		mongoOperation.updateFirst(query,
				Update.update("graduatedDate", new Date()), Customer.class);
		mongoOperation.updateFirst(query, Update.update("graduated", true),
				Customer.class);
	}

	public List<Customer> getAllActiveNonGraduatedCustomers() {
		Criteria c1 = Criteria.where("isActive").is(true);
		Criteria c2 = Criteria.where("graduated").is(false);
		Query query = new Query(new Criteria().andOperator(c1, c2));
		return mongoOperation.find(query, Customer.class);
	}

	public void prepareResponseForDownload(HttpServletResponse response,
			String contentType, String filename) {
		response.setHeader("Expires", "0");
		response.setHeader("Cache-Control",
				"must-revalidate, post-check=0, pre-check=0");
		response.setHeader("Pragma", "public");
		response.setContentType(contentType);
		response.addHeader("Content-Disposition", "attachment; filename="
				+ filename);
	}

	public void downloadBarcode(HttpServletResponse response, String id) {
		// get customer from id
		Customer customer = findCustomer(id);

		// create filename
		String filename = customer.getFirstName() + customer.getLastName()
				+ "(" + customer.getPetName() + ").pdf";

		// setup response header
		prepareResponseForDownload(response, HaywoodConstants.CONTENT_TYPE_PDF,
				filename);

		try {

			Document document = new Document(PageSize.A7.rotate());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PdfWriter writer = PdfWriter.getInstance(document, baos);
			document.open();

			PdfPTable table = new PdfPTable(1);
			table.setWidthPercentage(100);
			Font font = new Font(FontFamily.HELVETICA, 12, Font.BOLD,
					BaseColor.BLACK);

			// add information cell to top
			PdfPCell cell = new PdfPCell(new Phrase(
					(customer.getFirstName() + " " + customer.getLastName() + " ("
							+ customer.getPetName() + ")"), font));
			cell.setBorder(0);
			cell.setHorizontalAlignment(1);
			table.addCell(cell);

			//add barcode cell
			Barcode128 barcode = new Barcode128();
			barcode.setCodeType(Barcode128.CODE128);
			barcode.setCode(customer.getId().trim());
			barcode.setBarHeight(70f);
			cell = new PdfPCell(
					barcode.createImageWithBarcode(writer.getDirectContent(),
							BaseColor.BLACK, BaseColor.GRAY), true);
			cell.setBorder(0);
			cell.setPadding(10);
			table.addCell(cell);

			document.add(table);
			document.close();

			
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
			os.close();
		} catch (DocumentException | IOException e) {
			e.printStackTrace();
		}

	}

}
