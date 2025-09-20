package com.heartbeat.infantmortality;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.heartbeat.infantmortality.InfantMortalityXmlModel.*;
@Component
public class InfantMortatlityLogic {
	public MainDet MainDet;
    public PBA PBA;
    public ADM ADM;
    public PEMC PEMC;
    public ARF ARF;
    public ARFO ARFO;
    public LAB LAB;
    public CLB CLB;
    public ASD ASD;
    public OH OH;
    public OHO OHO;
    public RESCUDET RESCUDET;
    public RESCUDETOTHR RESCUDETOTHR;
    public POSTHIS POSTHIS;
    public DETOFDETH DETOFDETH;
    public CRITDELY CRITDELY;
    public MODFACT MODFACT;
    public MODFACTOTHR MODFACTOTHR;
    public NAS NAS;
    public ACTLEVLFAC ACTLEVLFAC;
    public CASSUMM CASSUMM;
    public PATDET PATDET;
    
    private static final Map<String, Class<?>> xmlTagClassMap = new HashMap<>();
    static {
    	xmlTagClassMap.put("MainDet", MainDet.class);
    	xmlTagClassMap.put("PBA", PBA.class);
    	xmlTagClassMap.put("ADM", ADM.class);
    	xmlTagClassMap.put("PEMC", PEMC.class);
        xmlTagClassMap.put("ARF", ARF.class);
        xmlTagClassMap.put("ARFO", ARFO.class);
        xmlTagClassMap.put("LAB", LAB.class);
        xmlTagClassMap.put("CLB", CLB.class);
        xmlTagClassMap.put("ASD", ASD.class);
        xmlTagClassMap.put("OH", OH.class);
        xmlTagClassMap.put("OHO", OHO.class);
        xmlTagClassMap.put("RESCUDET", RESCUDET.class);
        xmlTagClassMap.put("RESCUDETOTHR", RESCUDETOTHR.class);
        xmlTagClassMap.put("POSTHIS", POSTHIS.class);
        xmlTagClassMap.put("DETOFDETH", DETOFDETH.class);
        xmlTagClassMap.put("CRITDELY", CRITDELY.class);
        xmlTagClassMap.put("MODFACT", MODFACT.class);
        xmlTagClassMap.put("MODFACTOTHR", MODFACTOTHR.class);
        xmlTagClassMap.put("NAS", NAS.class);
        xmlTagClassMap.put("ACTLEVLFAC", ACTLEVLFAC.class);
        xmlTagClassMap.put("CASSUMM", CASSUMM.class);
        xmlTagClassMap.put("PATDET", PATDET.class);
    }

    public <T> T parseAndAssign(String tab, String xmlDataString) throws Exception {
        Class<?> xmlTagClass = xmlTagClassMap.get(tab);
        if (xmlTagClass == null) {
            System.err.println("No class mapping found for tab: " + tab);
            return null;
        }
        XmlMapper mapper = new XmlMapper();
        Object parsed = mapper.readValue(xmlDataString, xmlTagClass);
        Field field = this.getClass().getDeclaredField(tab);
        field.setAccessible(true);
        field.set(this, parsed);
        return (T)parsed;
    }
    
    public void formatDateAndTimeFields(InfantMortalityData data) {
        Field[] fields = InfantMortalityData.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object section = field.get(data);

                if (section != null) {
                    Field[] innerFields = section.getClass().getDeclaredFields();
                    for (Field innerField : innerFields) {
                        if (Base.class.isAssignableFrom(innerField.getType())) {
                            innerField.setAccessible(true);
                            Object valueObj = innerField.get(section);
                            if (valueObj instanceof Base) {
                                Base base = (Base) valueObj;
                                String fieldName = innerField.getName().toLowerCase();
                                String val = base.getValue();

                                if (val != null && !val.isEmpty()) {
                                    try {
                                        if (fieldName.toLowerCase().contains("date") || fieldName.toLowerCase().contains("dob")) {
                                            LocalDate date = LocalDate.parse(val, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                            base.setValue(date.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
                                        } else if (fieldName.toLowerCase().contains("time")) {
                                            LocalTime time = LocalTime.parse(val, DateTimeFormatter.ofPattern("HH:mm:ss"));
                                            base.setValue(time.format(DateTimeFormatter.ofPattern("HHmm")));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                }

            } catch (IllegalAccessException e) {
               e.printStackTrace();
            }
        }
    }

    public String generateXml(InfantMortalityXmlModel.InfantMortalityData data) throws Exception {
        StringWriter stringWriter = new StringWriter();
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter xmlWriter = xmlOutputFactory.createXMLStreamWriter(stringWriter);
        xmlWriter.writeStartDocument("UTF-8", "1.0");
        xmlWriter.writeStartElement("Root");
        processFields(xmlWriter, data);
        xmlWriter.writeEndElement();
        xmlWriter.writeEndDocument();
        xmlWriter.close();
        return stringWriter.toString();
    }

    private void processFields(XMLStreamWriter xmlWriter, Object object) throws Exception {
        if (object == null) {
            return;
        }
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(object);

            if (value instanceof InfantMortalityXmlModel.Base) {
                InfantMortalityXmlModel.Base baseValue = (InfantMortalityXmlModel.Base) value;
                String fieldName = field.getName();
                xmlWriter.writeStartElement(fieldName);
                // Always write value, even if null
                String fieldVal = baseValue.getValue() == null ? "" : baseValue.getValue();
                xmlWriter.writeAttribute("value", fieldVal.replace(",", " "));
                xmlWriter.writeEndElement();

            } else if (value != null && !field.getType().isPrimitive()) {
                String fieldName = field.getName();
                xmlWriter.writeStartElement(fieldName);
                processFields(xmlWriter, value);
                xmlWriter.writeEndElement();

            } else if (value == null && !field.getType().isPrimitive()) {
                String fieldName = field.getName();
                xmlWriter.writeStartElement(fieldName);
                xmlWriter.writeAttribute("value", "");
                xmlWriter.writeEndElement();
            }
        }
    }

}
