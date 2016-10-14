/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ekon;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

/**
 *
 * @author George
 */
public class zamestnanecToPDF {

    Zamestnanec aktZam;

    // nastaveni fontu
    private static String FILE = "c:/Users/George/My Documents/FiraPdf.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    public zamestnanecToPDF(Zamestnanec aktualniZamestnanec) {
        this.aktZam = aktualniZamestnanec;
    }

    public void vytvorPDF(String cestaUlozeni) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(cestaUlozeni));
            document.open();
            addMetaData(document);
            addTitlePage(document,aktZam);
          
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * pridani metadat pro prohlizac
     *
     * @param dokument
     */
    private static void addMetaData(Document dokument) {
        dokument.addTitle("Výpis zamštnance");
        dokument.addSubject("Výpis,zaměstnanec");
        dokument.addKeywords("Zaměstnanec,Výpis");
        dokument.addCreator("Ekon");
    }

    /**
     * pridani titulku
     *
     * @param dokument
     * @throws DocumentException
     */
    private static void addTitlePage(Document document, Zamestnanec zam) throws DocumentException {
     if(zam == null){
         System.out.println("chyba");
       return;
     }
        String jmeno = zam.getJmeno();
        String prijmeni = zam.getPrijmeni();
        String datumNarozeni = zam.getDatumNarozeni();
        String mesto = zam.getMesto();
        String ulice = zam.getUlice();
        String kraj = zam.getKraj();
        String pozice = zam.getPozice();
        Anchor anchor = new Anchor("Vypis zamestnance", catFont);
    anchor.setName("Vypis zamestnance");

    // Second parameter is the number of the chapter
    Chapter catPart = new Chapter(new Paragraph(anchor), 1);

    Paragraph subPara = new Paragraph("Zamestnanec", subFont);
    Section subCatPart = catPart.addSection(subPara);
    subCatPart.add(new Paragraph("Jmeno : "+jmeno));
    subCatPart.add(new Paragraph("Prijmeni : "+prijmeni));
    subCatPart.add(new Paragraph("Datum narozeni : "+datumNarozeni));
    subCatPart.add(new Paragraph("Mesto : "+mesto));
    subCatPart.add(new Paragraph("Ulice: "+ulice));
    subCatPart.add(new Paragraph("Kraj : "+kraj));
    subCatPart.add(new Paragraph("Pozice : "+pozice));
    
    subPara = new Paragraph("Vypis hodin", subFont);
    subCatPart = catPart.addSection(subPara);

    Paragraph paragraph = new Paragraph();
    addEmptyLine(paragraph, 3);
    subCatPart.add(paragraph);

    // add a table
    createTable(subCatPart);

    // now add all this to the document
    document.add(catPart);  
    }

 

    private static void createTable(Section subCatPart)
            throws BadElementException {
        PdfPTable table = new PdfPTable(3);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
        PdfPCell c1 = new PdfPCell(new Phrase("Mesic"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("Pocet odpracovanych hodin hodin"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
        subCatPart.add(table);
        
    }

    /**
     * Pridani prazdneho radku
     *
     * @param paragraph
     * @param number
     */
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
