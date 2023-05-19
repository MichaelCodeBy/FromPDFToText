package com.example.convertpdftotextinjava;

import com.aspose.pdf.Document;
import com.aspose.pdf.TextAbsorber;
import com.aspose.pdf.TextExtractionOptions;
import com.aspose.pdf.internal.html.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

@SpringBootApplication
public class ConvertPdfToTextInJavaApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(ConvertPdfToTextInJavaApplication.class, args);


        // main method to convert a PDF document to Text file
        // Instantiate the license to avoid trial limitations while converting the PDF to a text file
        License asposePdfLicenseText = new License();
        asposePdfLicenseText.setLicense("Aspose.pdf.lic");


        // Load the source PDF file that is to be converted to Text file
        Document convertPDFDocumentToText = new Document("Head_First.pdf");


        // Instantiate a TextAbsorber class object for converting PDF to Text
        TextAbsorber textAbsorber = new TextAbsorber(new TextExtractionOptions(TextExtractionOptions.TextFormattingMode.Pure));


        // Call the Accept method exposed by the TextAbsorber class
        convertPDFDocumentToText.getPages().accept(textAbsorber);


        // Read the text as string
        String ExtractedText = textAbsorber.getText();


        // Create the BufferedWriter object to open the file
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("SampleOutput.txt")));

        // Write extracted contents to the file
        writer.write(ExtractedText);

        // Close writer
        writer.close();


        System.out.println("Done");
    }

   // public static void main(String[] args) {
    }


