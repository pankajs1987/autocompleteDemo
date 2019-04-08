package com.pramati.sample.autocomplete;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class Application {

	
	public static List<String> citiesList = new ArrayList<>();
	public static void main(String[] args) {
		//Adding Up static data of Cities data from excel downloaded from given URL
		readExcel();
		SpringApplication.run(Application.class, args);
	}

	/*
	 * Static code to read excel and provide data for further Use
	 * 
	 * @return void
	 * 
	 */
	public static void readExcel() {
		try {
			File file = ResourceUtils.getFile("classpath:dummyDataCities.xlsx"); 
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				citiesList.add(row.getCell(0).getStringCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
