package com.tecsup.demo.views;

import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.tecsup.demo.domain.entities.Alumno;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("alumno/ver")
public class AlumnoPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Alumno> alumnos = (List<Alumno>)model.get("alumnos");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = null;

        cell = new PdfPCell(new Phrase("Lista de Alumnos"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(7);
        tabla2.addCell("ID");
        tabla2.addCell("Nombres");
        tabla2.addCell("Apellidos");
        tabla2.addCell("Fecha Nacimiento");
        tabla2.addCell("Correo");
        tabla2.addCell("Teléfono");
        tabla2.addCell("Carrera"); // Nueva columna

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for(Alumno alumno: alumnos) {
            tabla2.addCell(""+alumno.getId());
            tabla2.addCell(alumno.getNombres());
            tabla2.addCell(alumno.getApellidos());
            tabla2.addCell(alumno.getFechaNacimiento() != null ?
                    alumno.getFechaNacimiento().format(formatter) : "");
            tabla2.addCell(alumno.getCorreo());
            tabla2.addCell(alumno.getTelefono() != null ? alumno.getTelefono() : "");
            tabla2.addCell(alumno.getCarrera());
        }
        document.add(tabla);
        document.add(tabla2);
    }
}