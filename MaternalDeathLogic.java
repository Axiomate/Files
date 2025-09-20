package com.heartbeat.maternaldeath;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.heartbeat.maternaldeath.MaternalDeathXmlModel.*;

@Component
public class MaternalDeathLogic {
    public EventDetails EventDetails;
    public EventLocation EventLocation;
    public IDENTIFICATION Identification;
    public ObstetricHistory ObstetricHistory;
    public PreExistingMedicalConditions PreExistingMedicalConditions;
    public AntenatalRiskFactors AntenatalRiskFactors;
    public LaboratoryTest LaboratoryTest;
    public PathwayBeforeAdmission PathwayBeforeAdmission;
    public Admission Admission;
    public VitalSigns VitalSigns;
    public AbdominalExamination AbdominalExamination;
    public PelvicExamination PelvicExamination;
    public AdmissionComplications AdmissionComplications;
    public LabourAndBirth LabourAndBirth;
    public ApgarScore ApgarScore;
    public EarlyPregnancy EarlyPregnancy;
    public Antepartum Antepartum;
    public Intrapartum Intrapartum;
    public Postpartum Postpartum;
    public OtherInterventions OtherInterventions;
    public DetailsOfTheDeath DetailsOfTheDeath;
    public CriticalDelays CriticalDelays;
    public ModifiableFactors ModifiableFactors;
    public Formcompletedby Formcompletedby;
    public ActionsAtHospitalLevel ActionsAtHospitalLevel;
    
    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd")
                             .withResolverStyle(ResolverStyle.STRICT);

    private static final DateTimeFormatter TIME_FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss")
                             .withResolverStyle(ResolverStyle.STRICT);


    private static boolean isValidDate(String input) {
        try {
            LocalDate.parse(input, DATE_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private static boolean isValidTime(String input) {
        try {
            LocalTime.parse(input, TIME_FORMATTER);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private static final Map<String, Class<?>> xmlTagClassMap = new HashMap<>();
    static {
        xmlTagClassMap.put("EventDetails", EventDetails.class);
        xmlTagClassMap.put("EventLocation", EventLocation.class);
        xmlTagClassMap.put("IDENTIFICATION", IDENTIFICATION.class);
        xmlTagClassMap.put("ObstetricHistory", ObstetricHistory.class);
        xmlTagClassMap.put("PreExistingMedicalConditions", PreExistingMedicalConditions.class);
        xmlTagClassMap.put("AntenatalRiskFactors", AntenatalRiskFactors.class);
        xmlTagClassMap.put("LaboratoryTest", LaboratoryTest.class);
        xmlTagClassMap.put("PathwayBeforeAdmission", PathwayBeforeAdmission.class);
        xmlTagClassMap.put("Admission", Admission.class);
        xmlTagClassMap.put("VitalSigns", VitalSigns.class);
        xmlTagClassMap.put("AbdominalExamination", AbdominalExamination.class);
        xmlTagClassMap.put("PelvicExamination", PelvicExamination.class);
        xmlTagClassMap.put("AdmissionComplications", AdmissionComplications.class);
        xmlTagClassMap.put("LabourAndBirth", LabourAndBirth.class);
        xmlTagClassMap.put("ApgarScore", ApgarScore.class);
        xmlTagClassMap.put("EarlyPregnancy", EarlyPregnancy.class);
        xmlTagClassMap.put("Antepartum", Antepartum.class);
        xmlTagClassMap.put("Intrapartum", Intrapartum.class);
        xmlTagClassMap.put("Postpartum", Postpartum.class);
        xmlTagClassMap.put("OtherInterventions", OtherInterventions.class);
        xmlTagClassMap.put("DetailsOfTheDeath", DetailsOfTheDeath.class);
        xmlTagClassMap.put("CriticalDelays", CriticalDelays.class);
        xmlTagClassMap.put("ModifiableFactors", ModifiableFactors.class);
        xmlTagClassMap.put("Formcompletedby", Formcompletedby.class);
        xmlTagClassMap.put("ActionsAtHospitalLevel", ActionsAtHospitalLevel.class);
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
        return (T) parsed;
    }
    
    

    public void formatDateAndTimeFields(MaternalDeathData data) {
        Field[] fields = MaternalDeathData.class.getDeclaredFields();
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
                            	Base v = (Base) valueObj;
                                String fieldName = innerField.getName().toLowerCase();
                                String val = v.getValue();
                                if (val != null && !val.isEmpty()) {
                                	try {
                                        if (isValidDate(val)) {
                                            LocalDate date = LocalDate.parse(val, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                                            v.setValue(date.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
                                        } else if (isValidTime(val)) {
                                            LocalTime time = LocalTime.parse(val, DateTimeFormatter.ofPattern("HH:mm:ss"));
                                            v.setValue(time.format(DateTimeFormatter.ofPattern("HHmm")));
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

    public String generateXml(MaternalDeathData data) throws Exception {
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
            if (value instanceof MaternalDeathXmlModel.Base) {
            	MaternalDeathXmlModel.Base baseValue = (MaternalDeathXmlModel.Base) value;
                String fieldName = field.getName();
                xmlWriter.writeStartElement(fieldName);
                String fieldVal = baseValue.getValue() == null ? "" : baseValue.getValue();
                xmlWriter.writeAttribute("value", fieldVal);
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
