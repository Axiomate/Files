package com.heartbeat.infantmortality;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.lang.reflect.Field;

public class InfantMortalityXmlModel {

	public static <T> Map<String, String> convertXmlObjectToMap(T obj) {
		Map<String, String> result = new HashMap<>();

		for (Field field : obj.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				Object value = field.get(obj);

				if (value instanceof Base) {
					result.put(camelToSnake(field.getName()), ((Base) value).getValue());
				} else if (value != null) {
					result.put(camelToSnake(field.getName()), value.toString());
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	private static String camelToSnake(String str) {
		return str.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
	}

	public static class Base {
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@JacksonXmlProperty(isAttribute = true)
		public String value;
	}

	@JacksonXmlRootElement(localName = "Root")
	public static class InfantMortalityData {
		public MainDet getMainDet() {
			return MainDet;
		}

		public void setMainDet(MainDet mainDet) {
			MainDet = mainDet;
		}

		public PBA getPBA() {
			return PBA;
		}

		public void setPBA(PBA pBA) {
			PBA = pBA;
		}

		public ADM getADM() {
			return ADM;
		}

		public void setADM(ADM aDM) {
			ADM = aDM;
		}

		public PEMC getPEMC() {
			return PEMC;
		}

		public void setPEMC(PEMC pEMC) {
			PEMC = pEMC;
		}

		public ARF getARF() {
			return ARF;
		}

		public void setARF(ARF aRF) {
			ARF = aRF;
		}

		public ARFO getARFO() {
			return ARFO;
		}

		public void setARFO(ARFO aRFO) {
			ARFO = aRFO;
		}

		public LAB getLAB() {
			return LAB;
		}

		public void setLAB(LAB lAB) {
			LAB = lAB;
		}

		public CLB getCLB() {
			return CLB;
		}

		public void setCLB(CLB cLB) {
			CLB = cLB;
		}

		public ASD getASD() {
			return ASD;
		}

		public void setASD(ASD aSD) {
			ASD = aSD;
		}

		public OH getOH() {
			return OH;
		}

		public void setOH(OH oH) {
			OH = oH;
		}

		public OHO getOHO() {
			return OHO;
		}

		public void setOHO(OHO oHO) {
			OHO = oHO;
		}

		public RESCUDET getRESCUDET() {
			return RESCUDET;
		}

		public void setRESCUDET(RESCUDET rESCUDET) {
			RESCUDET = rESCUDET;
		}

		public RESCUDETOTHR getRESCUDETOTHR() {
			return RESCUDETOTHR;
		}

		public void setRESCUDETOTHR(RESCUDETOTHR rESCUDETOTHR) {
			RESCUDETOTHR = rESCUDETOTHR;
		}

		public POSTHIS getPOSTHIS() {
			return POSTHIS;
		}

		public void setPOSTHIS(POSTHIS pOSTHIS) {
			POSTHIS = pOSTHIS;
		}

		public DETOFDETH getDETOFDETH() {
			return DETOFDETH;
		}

		public void setDETOFDETH(DETOFDETH dETOFDETH) {
			DETOFDETH = dETOFDETH;
		}

		public CRITDELY getCRITDELY() {
			return CRITDELY;
		}

		public void setCRITDELY(CRITDELY cRITDELY) {
			CRITDELY = cRITDELY;
		}

		public MODFACT getMODFACT() {
			return MODFACT;
		}

		public void setMODFACT(MODFACT mODFACT) {
			MODFACT = mODFACT;
		}

		public MODFACTOTHR getMODFACTOTHR() {
			return MODFACTOTHR;
		}

		public void setMODFACTOTHR(MODFACTOTHR mODFACTOTHR) {
			MODFACTOTHR = mODFACTOTHR;
		}

		public NAS getNAS() {
			return NAS;
		}

		public void setNAS(NAS nAS) {
			NAS = nAS;
		}

		public ACTLEVLFAC getACTLEVLFAC() {
			return ACTLEVLFAC;
		}

		public void setACTLEVLFAC(ACTLEVLFAC aCTLEVLFAC) {
			ACTLEVLFAC = aCTLEVLFAC;
		}

		public CASSUMM getCASSUMM() {
			return CASSUMM;
		}

		public void setCASSUMM(CASSUMM cASSUMM) {
			CASSUMM = cASSUMM;
		}

		public PATDET getPATDET() {
			return PATDET;
		}

		public void setPATDET(PATDET pATDET) {
			PATDET = pATDET;
		}
		
		public int getDateFormatForXmlGeneration() {
			return dateFormatForXmlGeneration;
		}

		public void setDateFormatForXmlGeneration(int dateFormatForXmlGeneration) {
			this.dateFormatForXmlGeneration = dateFormatForXmlGeneration;
		}
		
		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}
		public int mainDetId;
		public int dateFormatForXmlGeneration;
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
	}

	public static class MainDet {
		public Base Domain = new Base();
		public Base EventOccurrenceDate = new Base();
		public Base EventOccurrenceTime = new Base();
		public Base EventSubmittedDate = new Base();
		public Base EventSubmittedTime = new Base();
		public Base EventUpdatedDate = new Base();
		public Base FacilityRegions = new Base();
		public Base FacilityCity = new Base();
		public Base HealthCareFacilityName = new Base();
		public Base FacilityMFID = new Base();
		public Base FacilityGroup = new Base();
		public Base FacilityType = new Base();
		public Base HCFEventID = new Base();
		public Base EventClosedDate = new Base();
		public Base EventRecordStatus = new Base();		
		@JacksonXmlProperty(isAttribute = true)
		public int id;
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		@JacksonXmlProperty(isAttribute = true)
		public int ipId;
		@JacksonXmlProperty(isAttribute = true)
		public int rehabBillId;

		public int getIpId() {
			return ipId;
		}

		public void setIpId(int ipId) {
			this.ipId = ipId;
		}

		public int getRehabBillId() {
			return rehabBillId;
		}

		public void setRehabBillId(int rehabBillId) {
			this.rehabBillId = rehabBillId;
		}

		public Base getDomain() {
			return Domain;
		}

		public void setDomain(Base domain) {
			domain.setValue("Mortality");
			Domain = domain;
		}

		public Base getEventOccurrenceDate() {
			return EventOccurrenceDate;
		}

		public void setEventOccurrenceDate(Base eventOccurrenceDate) {
			EventOccurrenceDate = eventOccurrenceDate;
		}

		public Base getEventOccurrenceTime() {
			return EventOccurrenceTime;
		}

		public void setEventOccurrenceTime(Base eventOccurrenceTime) {
			EventOccurrenceTime = eventOccurrenceTime;
		}

		public Base getEventSubmittedDate() {
			return EventSubmittedDate;
		}

		public void setEventSubmittedDate(Base eventSubmittedDate) {
			EventSubmittedDate = eventSubmittedDate;
		}

		public Base getEventSubmittedTime() {
			return EventSubmittedTime;
		}

		public void setEventSubmittedTime(Base eventSubmittedTime) {
			EventSubmittedTime = eventSubmittedTime;
		}

		public Base getEventUpdatedDate() {
			return EventUpdatedDate;
		}

		public void setEventUpdatedDate(Base eventUpdatedDate) {
			EventUpdatedDate = eventUpdatedDate;
		}

		public Base getFacilityRegions() {
			return FacilityRegions;
		}

		public void setFacilityRegions(Base facilityRegions) {
			FacilityRegions = facilityRegions;
		}

		public Base getFacilityCity() {
			return FacilityCity;
		}

		public void setFacilityCity(Base facilityCity) {
			FacilityCity = facilityCity;
		}

		public Base getHealthCareFacilityName() {
			return HealthCareFacilityName;
		}

		public void setHealthCareFacilityName(Base healthCareFacilityName) {
			HealthCareFacilityName = healthCareFacilityName;
		}

		public Base getFacilityMFID() {
			return FacilityMFID;
		}

		public void setFacilityMFID(Base facilityMFID) {
			FacilityMFID = facilityMFID;
		}

		public Base getFacilityGroup() {
			return FacilityGroup;
		}

		public void setFacilityGroup(Base facilityGroup) {
			FacilityGroup = facilityGroup;
		}

		public Base getFacilityType() {
			return FacilityType;
		}

		public void setFacilityType(Base facilityType) {
			FacilityType = facilityType;
		}

		public Base getHCFEventID() {
			return HCFEventID;
		}

		public void setHCFEventID(Base hCFEventID) {
			HCFEventID = hCFEventID;
		}

		public Base getEventClosedDate() {
			return EventClosedDate;
		}

		public void setEventClosedDate(Base eventClosedDate) {
			EventClosedDate = eventClosedDate;
		}
		public Base getEventRecordStatus() {
			return EventRecordStatus;
		}

		public void setEventRecordStatus(Base eventRecordStatus) {
			EventRecordStatus = eventRecordStatus;
		}
		
		public MainDet() {
			Domain = new Base();
			Domain.setValue("Mortality");
		}
	}

	public static class PBA {
		public Base Transreferred = new Base();
		public Base Referredfrom = new Base();
		public Base ReasonsForReferral = new Base();
		public Base PreReferralManagement = new Base();
		public Base Ambulance = new Base();
		public Base MedicinesAndHealthOnBoard = new Base();
		public Base MedicinesAndHealthOnBoardSpecify = new Base();
		public Base DateOfOnsetOfSymptoms = new Base();
		public Base TimeOfOnsetOfSymptoms = new Base();
		public Base DateOfReferralDecision = new Base();
		public Base TimeOfReferralDecision = new Base();
		public Base DeathNotificationNumber = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getTransreferred() {
			return Transreferred;
		}

		public void setTransreferred(Base transreferred) {
			Transreferred = transreferred;
		}

		public Base getReferredfrom() {
			return Referredfrom;
		}

		public void setReferredfrom(Base referredfrom) {
			Referredfrom = referredfrom;
		}

		public Base getReasonsForReferral() {
			return ReasonsForReferral;
		}

		public void setReasonsForReferral(Base reasonsForReferral) {
			ReasonsForReferral = reasonsForReferral;
		}

		public Base getPreReferralManagement() {
			return PreReferralManagement;
		}

		public void setPreReferralManagement(Base preReferralManagement) {
			PreReferralManagement = preReferralManagement;
		}

		public Base getAmbulance() {
			return Ambulance;
		}

		public void setAmbulance(Base ambulance) {
			Ambulance = ambulance;
		}

		public Base getMedicinesAndHealthOnBoard() {
			return MedicinesAndHealthOnBoard;
		}

		public void setMedicinesAndHealthOnBoard(Base medicinesAndHealthOnBoard) {
			MedicinesAndHealthOnBoard = medicinesAndHealthOnBoard;
		}

		public Base getMedicinesAndHealthOnBoardSpecify() {
			return MedicinesAndHealthOnBoardSpecify;
		}

		public void setMedicinesAndHealthOnBoardSpecify(Base medicinesAndHealthOnBoardSpecify) {
			MedicinesAndHealthOnBoardSpecify = medicinesAndHealthOnBoardSpecify;
		}

		public Base getDateOfOnsetOfSymptoms() {
			return DateOfOnsetOfSymptoms;
		}

		public void setDateOfOnsetOfSymptoms(Base dateOfOnsetOfSymptoms) {
			DateOfOnsetOfSymptoms = dateOfOnsetOfSymptoms;
		}

		public Base getTimeOfOnsetOfSymptoms() {
			return TimeOfOnsetOfSymptoms;
		}

		public void setTimeOfOnsetOfSymptoms(Base timeOfOnsetOfSymptoms) {
			TimeOfOnsetOfSymptoms = timeOfOnsetOfSymptoms;
		}

		public Base getDateOfReferralDecision() {
			return DateOfReferralDecision;
		}

		public void setDateOfReferralDecision(Base dateOfReferralDecision) {
			DateOfReferralDecision = dateOfReferralDecision;
		}

		public Base getTimeOfReferralDecision() {
			return TimeOfReferralDecision;
		}

		public void setTimeOfReferralDecision(Base timeOfReferralDecision) {
			TimeOfReferralDecision = timeOfReferralDecision;
		}

		public Base getDeathNotificationNumber() {
			return DeathNotificationNumber;
		}

		public void setDeathNotificationNumber(Base deathNotificationNumber) {
			DeathNotificationNumber = deathNotificationNumber;
		}
	}

	public static class ADM {
		public Base DateOfAdmission = new Base();
		public Base TimeOfAdmission = new Base();
		public Base MainReasonComplaintForAdmission = new Base();
		public Base ReceivedIntensiveCare = new Base();
		public Base NICUPICUadmission  = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getDateOfAdmission() {
			return DateOfAdmission;
		}

		public void setDateOfAdmission(Base dateOfAdmission) {
			DateOfAdmission = dateOfAdmission;
		}

		public Base getTimeOfAdmission() {
			return TimeOfAdmission;
		}

		public void setTimeOfAdmission(Base timeOfAdmission) {
			TimeOfAdmission = timeOfAdmission;
		}

		public Base getMainReasonComplaintForAdmission() {
			return MainReasonComplaintForAdmission;
		}

		public void setMainReasonComplaintForAdmission(Base mainReasonComplaintForAdmission) {
			MainReasonComplaintForAdmission = mainReasonComplaintForAdmission;
		}

		public Base getReceivedIntensiveCare() {
			return ReceivedIntensiveCare;
		}

		public void setReceivedIntensiveCare(Base receivedIntensiveCare) {
			ReceivedIntensiveCare = receivedIntensiveCare;
		}
		
		public Base getNICUPICUadmission() {
			return NICUPICUadmission;
		}

		public void setNICUPICUadmission(Base nICUPICUadmission) {
			NICUPICUadmission = nICUPICUadmission;
		}
	}
	
	public static class PEMC {
		public Base Hypertension = new Base();
		public Base Diabetes = new Base();
		public Base DiabetesOther = new Base();
		public Base Anemia = new Base();
		public Base MentalDisorder = new Base();
		public Base InfectiousDiseases = new Base();
		public Base OtherPreExistingMedicalConditions = new Base();
		public Base OtherInfectiousDiseases = new Base();
		public Base CardiacDisease = new Base();
		public Base Hepatitis  = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getHypertension() {
			return Hypertension;
		}

		public void setHypertension(Base hypertension) {
			Hypertension = hypertension;
		}

		public Base getDiabetes() {
			return Diabetes;
		}

		public void setDiabetes(Base diabetes) {
			Diabetes = diabetes;
		}

		public Base getDiabetesOther() {
			return DiabetesOther;
		}

		public void setDiabetesOther(Base diabetesOther) {
			DiabetesOther = diabetesOther;
		}

		public Base getAnemia() {
			return Anemia;
		}

		public void setAnemia(Base anemia) {
			Anemia = anemia;
		}

		public Base getMentalDisorder() {
			return MentalDisorder;
		}

		public void setMentalDisorder(Base mentalDisorder) {
			MentalDisorder = mentalDisorder;
		}

		public Base getInfectiousDiseases() {
			return InfectiousDiseases;
		}

		public void setInfectiousDiseases(Base infectiousDiseases) {
			InfectiousDiseases = infectiousDiseases;
		}

		public Base getOtherPreExistingMedicalConditions() {
			return OtherPreExistingMedicalConditions;
		}

		public void setOtherPreExistingMedicalConditions(Base otherPreExistingMedicalConditions) {
			OtherPreExistingMedicalConditions = otherPreExistingMedicalConditions;
		}

		public Base getOtherInfectiousDiseases() {
			return OtherInfectiousDiseases;
		}

		public void setOtherInfectiousDiseases(Base otherInfectiousDiseases) {
			OtherInfectiousDiseases = otherInfectiousDiseases;
		}

		public Base getCardiacDisease() {
			return CardiacDisease;
		}

		public void setCardiacDisease(Base cardiacDisease) {
			CardiacDisease = cardiacDisease;
		}

		public Base getHepatitis() {
			return Hepatitis;
		}

		public void setHepatitis(Base hepatitis) {
			Hepatitis = hepatitis;
		}
		
	}

	public static class ARF {
		public Base Hypertension = new Base();
		public Base Proteinuria = new Base();
		public Base Glycosuria = new Base();
		public Base Anemia = new Base();
		public Base UrinaryTractInfection = new Base();
		public Base PlacentaPraevia = new Base();
		public Base PlacentaAccreta = new Base();
		public Base GroupBStreptococcus = new Base();
		public Base OtherAntenatalRiskFactors = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getHypertension() {
			return Hypertension;
		}

		public void setHypertension(Base hypertension) {
			Hypertension = hypertension;
		}

		public Base getProteinuria() {
			return Proteinuria;
		}

		public void setProteinuria(Base proteinuria) {
			Proteinuria = proteinuria;
		}

		public Base getGlycosuria() {
			return Glycosuria;
		}

		public void setGlycosuria(Base glycosuria) {
			Glycosuria = glycosuria;
		}

		public Base getAnemia() {
			return Anemia;
		}

		public void setAnemia(Base anemia) {
			Anemia = anemia;
		}

		public Base getUrinaryTractInfection() {
			return UrinaryTractInfection;
		}

		public void setUrinaryTractInfection(Base urinaryTractInfection) {
			UrinaryTractInfection = urinaryTractInfection;
		}

		public Base getPlacentaPraevia() {
			return PlacentaPraevia;
		}

		public void setPlacentaPraevia(Base placentaPraevia) {
			PlacentaPraevia = placentaPraevia;
		}

		public Base getPlacentaAccreta() {
			return PlacentaAccreta;
		}

		public void setPlacentaAccreta(Base placentaAccreta) {
			PlacentaAccreta = placentaAccreta;
		}

		public Base getGroupBStreptococcus() {
			return GroupBStreptococcus;
		}

		public void setGroupBStreptococcus(Base groupBStreptococcus) {
			GroupBStreptococcus = groupBStreptococcus;
		}

		public Base getOtherAntenatalRiskFactors() {
			return OtherAntenatalRiskFactors;
		}

		public void setOtherAntenatalRiskFactors(Base otherAntenatalRiskFactors) {
			OtherAntenatalRiskFactors = otherAntenatalRiskFactors;
		}
	}

	public static class ARFO {
		public Base AntenatalHospitalization = new Base();
		public Base AntenatalHospitalizationOther = new Base();
		public Base AntenatalImmunization = new Base();
		public Base AntenatalImmunizationOther = new Base();
		public Base AntenatalMedications = new Base();
		public Base AntenatalMedicationsList = new Base();
		public Base AntenatalSupplement = new Base();
		public Base AntenatalSupplementList = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getAntenatalHospitalization() {
			return AntenatalHospitalization;
		}

		public void setAntenatalHospitalization(Base antenatalHospitalization) {
			AntenatalHospitalization = antenatalHospitalization;
		}

		public Base getAntenatalHospitalizationOther() {
			return AntenatalHospitalizationOther;
		}

		public void setAntenatalHospitalizationOther(Base antenatalHospitalizationOther) {
			AntenatalHospitalizationOther = antenatalHospitalizationOther;
		}

		public Base getAntenatalImmunization() {
			return AntenatalImmunization;
		}

		public void setAntenatalImmunization(Base antenatalImmunization) {
			AntenatalImmunization = antenatalImmunization;
		}

		public Base getAntenatalImmunizationOther() {
			return AntenatalImmunizationOther;
		}

		public void setAntenatalImmunizationOther(Base antenatalImmunizationOther) {
			AntenatalImmunizationOther = antenatalImmunizationOther;
		}

		public Base getAntenatalMedications() {
			return AntenatalMedications;
		}

		public void setAntenatalMedications(Base antenatalMedications) {
			AntenatalMedications = antenatalMedications;
		}

		public Base getAntenatalMedicationsList() {
			return AntenatalMedicationsList;
		}

		public void setAntenatalMedicationsList(Base antenatalMedicationsList) {
			AntenatalMedicationsList = antenatalMedicationsList;
		}

		public Base getAntenatalSupplement() {
			return AntenatalSupplement;
		}

		public void setAntenatalSupplement(Base antenatalSupplement) {
			AntenatalSupplement = antenatalSupplement;
		}

		public Base getAntenatalSupplementList() {
			return AntenatalSupplementList;
		}

		public void setAntenatalSupplementList(Base antenatalSupplementList) {
			AntenatalSupplementList = antenatalSupplementList;
		}
	}

	public static class LAB {
		public Base ColourOfAnioticFluid = new Base();
		public Base AmnioticFluidSmellOffensive = new Base();
		public Base DecisionToDeliveryInterval = new Base();
		public Base TotalDurationOfRuptureOfMembrane = new Base();
		public Base DateMothersLMP = new Base();
		public Base MothersLMP = new Base();
		public Base DateOfBirth = new Base();
		public Base GestationalAge = new Base();
		public Base MethodOfEstimationOfGestationalAge = new Base();
		public Base PlaceOfChildbirth = new Base();
		public Base OtherPlaceOfChildbirth = new Base();
		public Base AttendantAtChildbirth = new Base();
		public Base OnsetOfLabour = new Base();
		public Base PartogramUsed = new Base();
		public Base ModeOfDelivery = new Base();
		public Base TypeOfAnaesthesiaGivenToMother = new Base();
		public Base DurationOfLabour = new Base();
		public Base OnsetOfMembraneRupture = new Base();
		public Base TimeOfBirth = new Base();
		public Base FetalHeartSoundsOnAdmission = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getColourOfAnioticFluid() {
			return ColourOfAnioticFluid;
		}

		public void setColourOfAnioticFluid(Base colourOfAnioticFluid) {
			ColourOfAnioticFluid = colourOfAnioticFluid;
		}

		public Base getAmnioticFluidSmellOffensive() {
			return AmnioticFluidSmellOffensive;
		}

		public void setAmnioticFluidSmellOffensive(Base amnioticFluidSmellOffensive) {
			AmnioticFluidSmellOffensive = amnioticFluidSmellOffensive;
		}

		public Base getDecisionToDeliveryInterval() {
			return DecisionToDeliveryInterval;
		}

		public void setDecisionToDeliveryInterval(Base decisionToDeliveryInterval) {
			DecisionToDeliveryInterval = decisionToDeliveryInterval;
		}

		public Base getTotalDurationOfRuptureOfMembrane() {
			return TotalDurationOfRuptureOfMembrane;
		}

		public void setTotalDurationOfRuptureOfMembrane(Base totalDurationOfRuptureOfMembrane) {
			TotalDurationOfRuptureOfMembrane = totalDurationOfRuptureOfMembrane;
		}

		public Base getDateMothersLMP() {
			return DateMothersLMP;
		}

		public void setDateMothersLMP(Base dateMothersLMP) {
			DateMothersLMP = dateMothersLMP;
		}

		public Base getMothersLMP() {
			return MothersLMP;
		}

		public void setMothersLMP(Base mothersLMP) {
			MothersLMP = mothersLMP;
		}

		public Base getDateOfBirth() {
			return DateOfBirth;
		}

		public void setDateOfBirth(Base dateOfBirth) {
			DateOfBirth = dateOfBirth;
		}

		public Base getGestationalAge() {
			return GestationalAge;
		}

		public void setGestationalAge(Base gestationalAge) {
			GestationalAge = gestationalAge;
		}

		public Base getMethodOfEstimationOfGestationalAge() {
			return MethodOfEstimationOfGestationalAge;
		}

		public void setMethodOfEstimationOfGestationalAge(Base methodOfEstimationOfGestationalAge) {
			MethodOfEstimationOfGestationalAge = methodOfEstimationOfGestationalAge;
		}

		public Base getPlaceOfChildbirth() {
			return PlaceOfChildbirth;
		}

		public void setPlaceOfChildbirth(Base placeOfChildbirth) {
			PlaceOfChildbirth = placeOfChildbirth;
		}

		public Base getOtherPlaceOfChildbirth() {
			return OtherPlaceOfChildbirth;
		}

		public void setOtherPlaceOfChildbirth(Base otherPlaceOfChildbirth) {
			OtherPlaceOfChildbirth = otherPlaceOfChildbirth;
		}

		public Base getAttendantAtChildbirth() {
			return AttendantAtChildbirth;
		}

		public void setAttendantAtChildbirth(Base attendantAtChildbirth) {
			AttendantAtChildbirth = attendantAtChildbirth;
		}

		public Base getOnsetOfLabour() {
			return OnsetOfLabour;
		}

		public void setOnsetOfLabour(Base onsetOfLabour) {
			OnsetOfLabour = onsetOfLabour;
		}

		public Base getPartogramUsed() {
			return PartogramUsed;
		}

		public void setPartogramUsed(Base partogramUsed) {
			PartogramUsed = partogramUsed;
		}

		public Base getModeOfDelivery() {
			return ModeOfDelivery;
		}

		public void setModeOfDelivery(Base modeOfDelivery) {
			ModeOfDelivery = modeOfDelivery;
		}

		public Base getTypeOfAnaesthesiaGivenToMother() {
			return TypeOfAnaesthesiaGivenToMother;
		}

		public void setTypeOfAnaesthesiaGivenToMother(Base typeOfAnaesthesiaGivenToMother) {
			TypeOfAnaesthesiaGivenToMother = typeOfAnaesthesiaGivenToMother;
		}

		public Base getDurationOfLabour() {
			return DurationOfLabour;
		}

		public void setDurationOfLabour(Base durationOfLabour) {
			DurationOfLabour = durationOfLabour;
		}

		public Base getOnsetOfMembraneRupture() {
			return OnsetOfMembraneRupture;
		}

		public void setOnsetOfMembraneRupture(Base onsetOfMembraneRupture) {
			OnsetOfMembraneRupture = onsetOfMembraneRupture;
		}

		public Base getTimeOfBirth() {
			return TimeOfBirth;
		}

		public void setTimeOfBirth(Base timeOfBirth) {
			TimeOfBirth = timeOfBirth;
		}

		public Base getFetalHeartSoundsOnAdmission() {
			return FetalHeartSoundsOnAdmission;
		}

		public void setFetalHeartSoundsOnAdmission(Base fetalHeartSoundsOnAdmission) {
			FetalHeartSoundsOnAdmission = fetalHeartSoundsOnAdmission;
		}
	}

	public static class CLB {
		public Base IntrapartumHemorrhage = new Base();
		public Base IntrapartumInfection = new Base();
		public Base CIntrapartumPreEclampsia = new Base();
		public Base CObstructedLabour = new Base();
		public Base RupturedUterus = new Base();
		public Base CCordProlapse = new Base();
		public Base CMalPresentation = new Base();
		public Base Maneuvers = new Base();
		public Base OtherManeuvers = new Base();
		public Base ShoulderDystocia = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getIntrapartumHemorrhage() {
			return IntrapartumHemorrhage;
		}

		public void setIntrapartumHemorrhage(Base intrapartumHemorrhage) {
			IntrapartumHemorrhage = intrapartumHemorrhage;
		}

		public Base getIntrapartumInfection() {
			return IntrapartumInfection;
		}

		public void setIntrapartumInfection(Base intrapartumInfection) {
			IntrapartumInfection = intrapartumInfection;
		}

		public Base getCIntrapartumPreEclampsia() {
			return CIntrapartumPreEclampsia;
		}

		public void setCIntrapartumPreEclampsia(Base cIntrapartumPreEclampsia) {
			CIntrapartumPreEclampsia = cIntrapartumPreEclampsia;
		}

		public Base getCObstructedLabour() {
			return CObstructedLabour;
		}

		public void setCObstructedLabour(Base cObstructedLabour) {
			CObstructedLabour = cObstructedLabour;
		}

		public Base getRupturedUterus() {
			return RupturedUterus;
		}

		public void setRupturedUterus(Base rupturedUterus) {
			RupturedUterus = rupturedUterus;
		}

		public Base getCCordProlapse() {
			return CCordProlapse;
		}

		public void setCCordProlapse(Base cCordProlapse) {
			CCordProlapse = cCordProlapse;
		}

		public Base getCMalPresentation() {
			return CMalPresentation;
		}

		public void setCMalPresentation(Base cMalPresentation) {
			CMalPresentation = cMalPresentation;
		}

		public Base getManeuvers() {
			return Maneuvers;
		}

		public void setManeuvers(Base maneuvers) {
			Maneuvers = maneuvers;
		}

		public Base getOtherManeuvers() {
			return OtherManeuvers;
		}

		public void setOtherManeuvers(Base otherManeuvers) {
			OtherManeuvers = otherManeuvers;
		}

		public Base getShoulderDystocia() {
			return ShoulderDystocia;
		}

		public void setShoulderDystocia(Base shoulderDystocia) {
			ShoulderDystocia = shoulderDystocia;
		}
	}

	public static class ASD {
		public Base ApgarScore1Min = new Base();
		public Base ApgarScore5Min = new Base();
		public Base ApgarScore10Min = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getApgarScore1Min() {
			return ApgarScore1Min;
		}

		public void setApgarScore1Min(Base apgarScore1Min) {
			ApgarScore1Min = apgarScore1Min;
		}

		public Base getApgarScore5Min() {
			return ApgarScore5Min;
		}

		public void setApgarScore5Min(Base apgarScore5Min) {
			ApgarScore5Min = apgarScore5Min;
		}

		public Base getApgarScore10Min() {
			return ApgarScore10Min;
		}

		public void setApgarScore10Min(Base apgarScore10Min) {
			ApgarScore10Min = apgarScore10Min;
		}
	}

	public static class OH {
		public Base Gravidity = new Base();
		public Base Parity = new Base();
		public Base LiveBirths = new Base();
		public Base Stillbirths = new Base();
		public Base SpontaneousAbortions = new Base();
		public Base InducedAbortion = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getGravidity() {
			return Gravidity;
		}

		public void setGravidity(Base gravidity) {
			Gravidity = gravidity;
		}

		public Base getParity() {
			return Parity;
		}

		public void setParity(Base parity) {
			Parity = parity;
		}

		public Base getLiveBirths() {
			return LiveBirths;
		}

		public void setLiveBirths(Base liveBirths) {
			LiveBirths = liveBirths;
		}

		public Base getStillbirths() {
			return Stillbirths;
		}

		public void setStillbirths(Base stillbirths) {
			Stillbirths = stillbirths;
		}

		public Base getSpontaneousAbortions() {
			return SpontaneousAbortions;
		}

		public void setSpontaneousAbortions(Base spontaneousAbortions) {
			SpontaneousAbortions = spontaneousAbortions;
		}

		public Base getInducedAbortion() {
			return InducedAbortion;
		}

		public void setInducedAbortion(Base inducedAbortion) {
			InducedAbortion = inducedAbortion;
		}
	}

	public static class OHO {
		public Base PreviousCesareanSections = new Base();
		public Base Number = new Base();
		public Base DateOfMostRecentsCS = new Base();
		public Base PreviousPregnancyComplications = new Base();
		public Base Description = new Base();
		public Base ContraceptionUseJustPriorToCurrentPregnancy = new Base();
		public Base TypeOfContraceptionUseJustPriorToCurrentPregnancy = new Base();
		public Base AssistedReproductiveTherapy = new Base();
		public Base TypeOfAssistedReproductiveTherapy = new Base();
		public Base CongenitalMalformationDetected = new Base();
		public Base TypeOfAssistedReproductiveTherapyOthers = new Base();
		public Base CongenitalGeneticAnomalies  = new Base();
		public Base CongenitalGeneticAnomaliesOthers  = new Base();
		public Base TypeOfPregnancy = new Base();
		public Base SpecifyNumberOfPregnancy = new Base();
		public Base BookingVisitAtCoded  = new Base();
		public Base BookingVisitAt = new Base();
		public Base AntenatalCareNumberOfVisits = new Base();
		public Base DateOfLastANCVisit = new Base();
		public Base ANCServicesProvidedAt = new Base();		
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getPreviousCesareanSections() {
			return PreviousCesareanSections;
		}

		public void setPreviousCesareanSections(Base previousCesareanSections) {
			PreviousCesareanSections = previousCesareanSections;
		}

		public Base getNumber() {
			return Number;
		}

		public void setNumber(Base number) {
			Number = number;
		}

		public Base getDateOfMostRecentsCS() {
			return DateOfMostRecentsCS;
		}

		public void setDateOfMostRecentsCS(Base dateOfMostRecentsCS) {
			DateOfMostRecentsCS = dateOfMostRecentsCS;
		}

		public Base getPreviousPregnancyComplications() {
			return PreviousPregnancyComplications;
		}

		public void setPreviousPregnancyComplications(Base previousPregnancyComplications) {
			PreviousPregnancyComplications = previousPregnancyComplications;
		}

		public Base getDescription() {
			return Description;
		}

		public void setDescription(Base description) {
			Description = description;
		}

		public Base getContraceptionUseJustPriorToCurrentPregnancy() {
			return ContraceptionUseJustPriorToCurrentPregnancy;
		}

		public void setContraceptionUseJustPriorToCurrentPregnancy(Base contraceptionUseJustPriorToCurrentPregnancy) {
			ContraceptionUseJustPriorToCurrentPregnancy = contraceptionUseJustPriorToCurrentPregnancy;
		}

		public Base getTypeOfContraceptionUseJustPriorToCurrentPregnancy() {
			return TypeOfContraceptionUseJustPriorToCurrentPregnancy;
		}

		public void setTypeOfContraceptionUseJustPriorToCurrentPregnancy(
				Base typeOfContraceptionUseJustPriorToCurrentPregnancy) {
			TypeOfContraceptionUseJustPriorToCurrentPregnancy = typeOfContraceptionUseJustPriorToCurrentPregnancy;
		}

		public Base getAssistedReproductiveTherapy() {
			return AssistedReproductiveTherapy;
		}

		public void setAssistedReproductiveTherapy(Base assistedReproductiveTherapy) {
			AssistedReproductiveTherapy = assistedReproductiveTherapy;
		}

		public Base getTypeOfAssistedReproductiveTherapy() {
			return TypeOfAssistedReproductiveTherapy;
		}

		public void setTypeOfAssistedReproductiveTherapy(Base typeOfAssistedReproductiveTherapy) {
			TypeOfAssistedReproductiveTherapy = typeOfAssistedReproductiveTherapy;
		}

		public Base getCongenitalMalformationDetected() {
			return CongenitalMalformationDetected;
		}

		public void setCongenitalMalformationDetected(Base CongenitalMalformationDetected) {
			CongenitalMalformationDetected = CongenitalMalformationDetected;
		}

		public Base getTypeOfPregnancy() {
			return TypeOfPregnancy;
		}

		public void setTypeOfPregnancy(Base typeOfPregnancy) {
			TypeOfPregnancy = typeOfPregnancy;
		}

		public Base getSpecifyNumberOfPregnancy() {
			return SpecifyNumberOfPregnancy;
		}

		public void setSpecifyNumberOfPregnancy(Base specifyNumberOfPregnancy) {
			SpecifyNumberOfPregnancy = specifyNumberOfPregnancy;
		}

		public Base getBookingVisitAt() {
			return BookingVisitAt;
		}

		public void setBookingVisitAt(Base bookingVisitAt) {
			BookingVisitAt = bookingVisitAt;
		}

		public Base getAntenatalCareNumberOfVisits() {
			return AntenatalCareNumberOfVisits;
		}

		public void setAntenatalCareNumberOfVisits(Base antenatalCareNumberOfVisits) {
			AntenatalCareNumberOfVisits = antenatalCareNumberOfVisits;
		}

		public Base getDateOfLastANCVisit() {
			return DateOfLastANCVisit;
		}

		public void setDateOfLastANCVisit(Base dateOfLastANCVisit) {
			DateOfLastANCVisit = dateOfLastANCVisit;
		}

		public Base getANCServicesProvidedAt() {
			return ANCServicesProvidedAt;
		}

		public void setANCServicesProvidedAt(Base aNCServicesProvidedAt) {
			ANCServicesProvidedAt = aNCServicesProvidedAt;
		}

		public Base getTypeOfAssistedReproductiveTherapyOthers() {
			return TypeOfAssistedReproductiveTherapyOthers;
		}

		public void setTypeOfAssistedReproductiveTherapyOthers(Base typeOfAssistedReproductiveTherapyOthers) {
			TypeOfAssistedReproductiveTherapyOthers = typeOfAssistedReproductiveTherapyOthers;
		}

		public Base getCongenitalGeneticAnomalies() {
			return CongenitalGeneticAnomalies;
		}

		public void setCongenitalGeneticAnomalies(Base congenitalGeneticAnomalies) {
			CongenitalGeneticAnomalies = congenitalGeneticAnomalies;
		}

		public Base getCongenitalGeneticAnomaliesOthers() {
			return CongenitalGeneticAnomaliesOthers;
		}

		public void setCongenitalGeneticAnomaliesOthers(Base congenitalGeneticAnomaliesOthers) {
			CongenitalGeneticAnomaliesOthers = congenitalGeneticAnomaliesOthers;
		}

		public Base getBookingVisitAtCoded() {
			return BookingVisitAtCoded;
		}

		public void setBookingVisitAtCoded(Base bookingVisitAtCoded) {
			BookingVisitAtCoded = bookingVisitAtCoded;
		}
		
	}

	public static class RESCUDET {
		public Base Resuscitation = new Base();
		public Base ResuscitationSpecify = new Base();
		public Base OtherResuscitation = new Base();
		public Base DelaydCordclamping  = new Base();
		public Base TypeOfDeath = new Base();
		public Base DateOfDeath = new Base();
		public Base TimeOfDeath = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getResuscitation() {
			return Resuscitation;
		}

		public void setResuscitation(Base resuscitation) {
			Resuscitation = resuscitation;
		}

		public Base getResuscitationSpecify() {
			return ResuscitationSpecify;
		}

		public void setResuscitationSpecify(Base resuscitationSpecify) {
			ResuscitationSpecify = resuscitationSpecify;
		}

		public Base getOtherResuscitation() {
			return OtherResuscitation;
		}

		public void setOtherResuscitation(Base otherResuscitation) {
			OtherResuscitation = otherResuscitation;
		}
		
		public Base getDelaydCordclamping() {
			return DelaydCordclamping;
		}

		public void setDelaydCordclamping(Base delaydCordclamping) {
			DelaydCordclamping = delaydCordclamping;
		}

		public Base getTypeOfDeath() {
			return TypeOfDeath;
		}

		public void setTypeOfDeath(Base typeOfDeath) {
			TypeOfDeath = typeOfDeath;
		}

		public Base getDateOfDeath() {
			return DateOfDeath;
		}

		public void setDateOfDeath(Base dateOfDeath) {
			DateOfDeath = dateOfDeath;
		}

		public Base getTimeOfDeath() {
			return TimeOfDeath;
		}

		public void setTimeOfDeath(Base timeOfDeath) {
			TimeOfDeath = timeOfDeath;
		}
	}

	public static class RESCUDETOTHR {
		public Base GenderOfBaby = new Base();
		public Base BirthWeight = new Base();
		public Base Length = new Base();
		public Base HeadCircumference = new Base();
		public Base CodedBirthWeight = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getGenderOfBaby() {
			return GenderOfBaby;
		}

		public void setGenderOfBaby(Base genderOfBaby) {
			GenderOfBaby = genderOfBaby;
		}

		public Base getBirthWeight() {
			return BirthWeight;
		}

		public void setBirthWeight(Base birthWeight) {
			BirthWeight = birthWeight;
		}

		public Base getLength() {
			return Length;
		}

		public void setLength(Base length) {
			Length = length;
		}

		public Base getHeadCircumference() {
			return HeadCircumference;
		}

		public void setHeadCircumference(Base headCircumference) {
			HeadCircumference = headCircumference;
		}

		public Base getCodedBirthWeight() {
			return CodedBirthWeight;
		}

		public void setCodedBirthWeight(Base codedBirthWeight) {
			CodedBirthWeight = codedBirthWeight;
		}
	}

	public static class POSTHIS {
		public Base TypeOfCareReceived = new Base();
		public Base TypeOfCareReceivedOthers = new Base();
		public Base Problems = new Base();
		public Base ProblemsOthers = new Base();
		public Base MedicalConditions = new Base();
		public Base OtherMedicalConditions = new Base();
		public Base CongenitalGeneticAnomalies = new Base();
		public Base OtherCongenitalGeneticAnomalies = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getTypeOfCareReceived() {
			return TypeOfCareReceived;
		}

		public void setTypeOfCareReceived(Base typeOfCareReceived) {
			TypeOfCareReceived = typeOfCareReceived;
		}

		public Base getProblems() {
			return Problems;
		}

		public void setProblems(Base problems) {
			Problems = problems;
		}

		public Base getMedicalConditions() {
			return MedicalConditions;
		}

		public void setMedicalConditions(Base medicalConditions) {
			MedicalConditions = medicalConditions;
		}

		public Base getOtherMedicalConditions() {
			return OtherMedicalConditions;
		}

		public void setOtherMedicalConditions(Base otherMedicalConditions) {
			OtherMedicalConditions = otherMedicalConditions;
		}

		public Base getTypeOfCareReceivedOthers() {
			return TypeOfCareReceivedOthers;
		}

		public void setTypeOfCareReceivedOthers(Base typeOfCareReceivedOthers) {
			TypeOfCareReceivedOthers = typeOfCareReceivedOthers;
		}

		public Base getProblemsOthers() {
			return ProblemsOthers;
		}

		public void setProblemsOthers(Base problemsOthers) {
			ProblemsOthers = problemsOthers;
		}

		public Base getCongenitalGeneticAnomalies() {
			return CongenitalGeneticAnomalies;
		}

		public void setCongenitalGeneticAnomalies(Base congenitalGeneticAnomalies) {
			CongenitalGeneticAnomalies = congenitalGeneticAnomalies;
		}

		public Base getOtherCongenitalGeneticAnomalies() {
			return OtherCongenitalGeneticAnomalies;
		}

		public void setOtherCongenitalGeneticAnomalies(Base otherCongenitalGeneticAnomalies) {
			OtherCongenitalGeneticAnomalies = otherCongenitalGeneticAnomalies;
		}
	}

	public static class DETOFDETH {
		public Base UnderlyingCause = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getUnderlyingCause() {
			return UnderlyingCause;
		}

		public void setUnderlyingCause(Base underlyingCause) {
			UnderlyingCause = underlyingCause;
		}
	}

	public static class CRITDELY {
		public Base CriticalDelays = new Base();
		public Base Delay1InSeekingCare = new Base();
		public Base OtherDelay1InSeekingCare = new Base();
		public Base Delay2InReachingFacility = new Base();
		public Base OtherDelay2InReachingFacility = new Base();
		public Base Delay3WithinHealthFacility = new Base();
		public Base OtherDelay3WithinHealthFacility = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getCriticalDelays() {
			return CriticalDelays;
		}

		public void setCriticalDelays(Base criticalDelays) {
			CriticalDelays = criticalDelays;
		}

		public Base getDelay1InSeekingCare() {
			return Delay1InSeekingCare;
		}

		public void setDelay1InSeekingCare(Base delay1InSeekingCare) {
			Delay1InSeekingCare = delay1InSeekingCare;
		}

		public Base getOtherDelay1InSeekingCare() {
			return OtherDelay1InSeekingCare;
		}

		public void setOtherDelay1InSeekingCare(Base otherDelay1InSeekingCare) {
			OtherDelay1InSeekingCare = otherDelay1InSeekingCare;
		}

		public Base getDelay2InReachingFacility() {
			return Delay2InReachingFacility;
		}

		public void setDelay2InReachingFacility(Base delay2InReachingFacility) {
			Delay2InReachingFacility = delay2InReachingFacility;
		}

		public Base getOtherDelay2InReachingFacility() {
			return OtherDelay2InReachingFacility;
		}

		public void setOtherDelay2InReachingFacility(Base otherDelay2InReachingFacility) {
			OtherDelay2InReachingFacility = otherDelay2InReachingFacility;
		}

		public Base getDelay3WithinHealthFacility() {
			return Delay3WithinHealthFacility;
		}

		public void setDelay3WithinHealthFacility(Base delay3WithinHealthFacility) {
			Delay3WithinHealthFacility = delay3WithinHealthFacility;
		}

		public Base getOtherDelay3WithinHealthFacility() {
			return OtherDelay3WithinHealthFacility;
		}

		public void setOtherDelay3WithinHealthFacility(Base otherDelay3WithinHealthFacility) {
			OtherDelay3WithinHealthFacility = otherDelay3WithinHealthFacility;
		}
	}

	public static class MODFACT {
		public Base ModifiableFactors = new Base();
		public Base FamilyRelated = new Base();
		public Base OtherFamilyRelated = new Base();
		public Base AdminstationRelated = new Base();
		public Base OtherAdminstationRelated = new Base();
		public Base ProviderRelated = new Base();
		public Base OtherProviderRelated = new Base();
		public Base OtherModifiableFactors = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getModifiableFactors() {
			return ModifiableFactors;
		}

		public void setModifiableFactors(Base modifiableFactors) {
			ModifiableFactors = modifiableFactors;
		}

		public Base getFamilyRelated() {
			return FamilyRelated;
		}

		public void setFamilyRelated(Base familyRelated) {
			FamilyRelated = familyRelated;
		}

		public Base getOtherFamilyRelated() {
			return OtherFamilyRelated;
		}

		public void setOtherFamilyRelated(Base otherFamilyRelated) {
			OtherFamilyRelated = otherFamilyRelated;
		}

		public Base getAdminstationRelated() {
			return AdminstationRelated;
		}

		public void setAdminstationRelated(Base adminstationRelated) {
			AdminstationRelated = adminstationRelated;
		}

		public Base getOtherAdminstationRelated() {
			return OtherAdminstationRelated;
		}

		public void setOtherAdminstationRelated(Base otherAdminstationRelated) {
			OtherAdminstationRelated = otherAdminstationRelated;
		}

		public Base getProviderRelated() {
			return ProviderRelated;
		}

		public void setProviderRelated(Base providerRelated) {
			ProviderRelated = providerRelated;
		}

		public Base getOtherProviderRelated() {
			return OtherProviderRelated;
		}

		public void setOtherProviderRelated(Base otherProviderRelated) {
			OtherProviderRelated = otherProviderRelated;
		}

		public Base getOtherModifiableFactors() {
			return OtherModifiableFactors;
		}

		public void setOtherModifiableFactors(Base otherModifiableFactors) {
			OtherModifiableFactors = otherModifiableFactors;
		}
	}

	public static class MODFACTOTHR {
		public Base WasTheDeathPreventable = new Base();
		public Base ActionToAddressTheCriticalDelaysAndModifiableFactors = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getWasTheDeathPreventable() {
			return WasTheDeathPreventable;
		}

		public void setWasTheDeathPreventable(Base wasTheDeathPreventable) {
			WasTheDeathPreventable = wasTheDeathPreventable;
		}

		public Base getActionToAddressTheCriticalDelaysAndModifiableFactors() {
			return ActionToAddressTheCriticalDelaysAndModifiableFactors;
		}

		public void setActionToAddressTheCriticalDelaysAndModifiableFactors(
				Base actionToAddressTheCriticalDelaysAndModifiableFactors) {
			ActionToAddressTheCriticalDelaysAndModifiableFactors = actionToAddressTheCriticalDelaysAndModifiableFactors;
		}
	}

	public static class NAS {
		public Base FormCompletedBy = new Base();
		public Base CompletedDesignation = new Base();
		public Base FormReviewedBy = new Base();
		public Base ReviewedDesignation = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getFormCompletedBy() {
			return FormCompletedBy;
		}

		public void setFormCompletedBy(Base formCompletedBy) {
			FormCompletedBy = formCompletedBy;
		}

		public Base getCompletedDesignation() {
			return CompletedDesignation;
		}

		public void setCompletedDesignation(Base completedDesignation) {
			CompletedDesignation = completedDesignation;
		}

		public Base getFormReviewedBy() {
			return FormReviewedBy;
		}

		public void setFormReviewedBy(Base formReviewedBy) {
			FormReviewedBy = formReviewedBy;
		}

		public Base getReviewedDesignation() {
			return ReviewedDesignation;
		}

		public void setReviewedDesignation(Base reviewedDesignation) {
			ReviewedDesignation = reviewedDesignation;
		}
	}

	public static class ACTLEVLFAC {
		public Base ImmediateActionTaken = new Base();
		public Base ActionRecommendedFromTheMMReviewCommittee = new Base();
		public Base HospitalMAndMReviewCommitteeChairpersonName = new Base();
		public Base Date = new Base();
		public Base Signature = new Base();
		public Base Email = new Base();
		public Base ContactNumber = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getImmediateActionTaken() {
			return ImmediateActionTaken;
		}

		public void setImmediateActionTaken(Base immediateActionTaken) {
			ImmediateActionTaken = immediateActionTaken;
		}

		public Base getActionRecommendedFromTheMMReviewCommittee() {
			return ActionRecommendedFromTheMMReviewCommittee;
		}

		public void setActionRecommendedFromTheMMReviewCommittee(Base actionRecommendedFromTheMMReviewCommittee) {
			ActionRecommendedFromTheMMReviewCommittee = actionRecommendedFromTheMMReviewCommittee;
		}

		public Base getHospitalMAndMReviewCommitteeChairpersonName() {
			return HospitalMAndMReviewCommitteeChairpersonName;
		}

		public void setHospitalMAndMReviewCommitteeChairpersonName(Base hospitalMAndMReviewCommitteeChairpersonName) {
			HospitalMAndMReviewCommitteeChairpersonName = hospitalMAndMReviewCommitteeChairpersonName;
		}

		public Base getDate() {
			return Date;
		}

		public void setDate(Base date) {
			Date = date;
		}

		public Base getSignature() {
			return Signature;
		}

		public void setSignature(Base signature) {
			Signature = signature;
		}

		public Base getEmail() {
			return Email;
		}

		public void setEmail(Base email) {
			Email = email;
		}

		public Base getContactNumber() {
			return ContactNumber;
		}

		public void setContactNumber(Base contactNumber) {
			ContactNumber = contactNumber;
		}
	}

	public static class CASSUMM {
		public Base AnyAdditionalNotes = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getAnyAdditionalNotes() {
			return AnyAdditionalNotes;
		}

		public void setAnyAdditionalNotes(Base anyAdditionalNotes) {
			AnyAdditionalNotes = anyAdditionalNotes;
		}
	}

	public static class PATDET {
		public Base MotherMrn = new Base();
		public Base MotherEMIDPassID = new Base();
		public Base MotherFname = new Base();
		public Base MotherLname = new Base();
		public Base MothersNationality = new Base();
		public Base MotherDOB = new Base();
		public Base MothersEducation = new Base();
		public Base MothersOccupation = new Base();
		public Base MothersOccupationSpecify = new Base();
		public Base MaritalStatus = new Base();
		public Base TypeOfMothersInsurance = new Base();
		public Base TypeOfMothersInsuranceOther = new Base();
		public Base ConsanguineousMarriage = new Base();
		public Base FathersEmploymentStatus = new Base();
		public Base FathersEmploymentEmployedOther = new Base();
		public Base FathersNationality = new Base();
		public Base FatherSmoker = new Base();
		public Base MotherSmoker = new Base();
		public Base DeceasedBabysFullName = new Base();
		public Base DeceasedBabysDateOfBirth = new Base();
		public Base DeceasedBabysMRN = new Base();
		public Base DeceasedEmiratesIDPassportNumber = new Base();
		public Base AttendedAtChildbirthOther = new Base();
		public Base UAEResidencyStatus = new Base();
		public Base BabysPlaceOfBirth  = new Base();
		public Base Address  = new Base();
		@JacksonXmlProperty(isAttribute = true)
		public int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		@JacksonXmlProperty(isAttribute = true)
		public int mainDetId;

		public int getMainDetId() {
			return mainDetId;
		}

		public void setMainDetId(int mainDetId) {
			this.mainDetId = mainDetId;
		}

		public Base getMotherMrn() {
			return MotherMrn;
		}

		public void setMotherMrn(Base motherMrn) {
			MotherMrn = motherMrn;
		}

		public Base getMotherEMIDPassID() {
			return MotherEMIDPassID;
		}

		public void setMotherEMIDPassID(Base motherEMIDPassID) {
			MotherEMIDPassID = motherEMIDPassID;
		}

		public Base getMotherFname() {
			return MotherFname;
		}

		public void setMotherFname(Base motherFname) {
			MotherFname = motherFname;
		}

		public Base getMotherLname() {
			return MotherLname;
		}

		public void setMotherLname(Base motherLname) {
			MotherLname = motherLname;
		}

		public Base getMothersNationality() {
			return MothersNationality;
		}

		public void setMothersNationality(Base mothersNationality) {
			MothersNationality = mothersNationality;
		}

		public Base getMotherDOB() {
			return MotherDOB;
		}

		public void setMotherDOB(Base motherDOB) {
			MotherDOB = motherDOB;
		}

		public Base getMothersEducation() {
			return MothersEducation;
		}

		public void setMothersEducation(Base mothersEducation) {
			MothersEducation = mothersEducation;
		}

		public Base getMothersOccupation() {
			return MothersOccupation;
		}

		public void setMothersOccupation(Base mothersOccupation) {
			MothersOccupation = mothersOccupation;
		}

		public Base getMothersOccupationSpecify() {
			return MothersOccupationSpecify;
		}

		public void setMothersOccupationSpecify(Base mothersOccupationSpecify) {
			MothersOccupationSpecify = mothersOccupationSpecify;
		}

		public Base getMaritalStatus() {
			return MaritalStatus;
		}

		public void setMaritalStatus(Base maritalStatus) {
			MaritalStatus = maritalStatus;
		}

		public Base getTypeOfMothersInsurance() {
			return TypeOfMothersInsurance;
		}

		public void setTypeOfMothersInsurance(Base typeOfMothersInsurance) {
			TypeOfMothersInsurance = typeOfMothersInsurance;
		}

		public Base getConsanguineousMarriage() {
			return ConsanguineousMarriage;
		}

		public void setConsanguineousMarriage(Base consanguineousMarriage) {
			ConsanguineousMarriage = consanguineousMarriage;
		}

		public Base getFathersEmploymentStatus() {
			return FathersEmploymentStatus;
		}

		public void setFathersEmploymentStatus(Base fathersEmploymentStatus) {
			FathersEmploymentStatus = fathersEmploymentStatus;
		}

		public Base getFathersEmploymentEmployedOther() {
			return FathersEmploymentEmployedOther;
		}

		public void setFathersEmploymentEmployedOther(Base fathersEmploymentEmployedOther) {
			FathersEmploymentEmployedOther = fathersEmploymentEmployedOther;
		}

		public Base getFathersNationality() {
			return FathersNationality;
		}

		public void setFathersNationality(Base fathersNationality) {
			FathersNationality = fathersNationality;
		}

		public Base getFatherSmoker() {
			return FatherSmoker;
		}

		public void setFatherSmoker(Base fatherSmoker) {
			FatherSmoker = fatherSmoker;
		}

		public Base getMotherSmoker() {
			return MotherSmoker;
		}

		public void setMotherSmoker(Base motherSmoker) {
			MotherSmoker = motherSmoker;
		}

		public Base getDeceasedBabysFullName() {
			return DeceasedBabysFullName;
		}

		public void setDeceasedBabysFullName(Base deceasedBabysFullName) {
			DeceasedBabysFullName = deceasedBabysFullName;
		}

		public Base getDeceasedBabysDateOfBirth() {
			return DeceasedBabysDateOfBirth;
		}

		public void setDeceasedBabysDateOfBirth(Base deceasedBabysDateOfBirth) {
			DeceasedBabysDateOfBirth = deceasedBabysDateOfBirth;
		}

		public Base getDeceasedBabysMRN() {
			return DeceasedBabysMRN;
		}

		public void setDeceasedBabysMRN(Base deceasedBabysMRN) {
			DeceasedBabysMRN = deceasedBabysMRN;
		}

		public Base getDeceasedEmiratesIDPassportNumber() {
			return DeceasedEmiratesIDPassportNumber;
		}

		public void setDeceasedEmiratesIDPassportNumber(Base deceasedEmiratesIDPassportNumber) {
			DeceasedEmiratesIDPassportNumber = deceasedEmiratesIDPassportNumber;
		}

		public Base getUAEResidencyStatus() {
			return UAEResidencyStatus;
		}

		public void setUAEResidencyStatus(Base uAEResidencyStatus) {
			UAEResidencyStatus = uAEResidencyStatus;
		}

		public Base getTypeOfMothersInsuranceOther() {
			return TypeOfMothersInsuranceOther;
		}

		public void setTypeOfMothersInsuranceOther(Base typeOfMothersInsuranceOther) {
			TypeOfMothersInsuranceOther = typeOfMothersInsuranceOther;
		}

		public Base getAttendedAtChildbirthOther() {
			return AttendedAtChildbirthOther;
		}

		public void setAttendedAtChildbirthOther(Base attendedAtChildbirthOther) {
			AttendedAtChildbirthOther = attendedAtChildbirthOther;
		}

		public Base getBabysPlaceOfBirth() {
			return BabysPlaceOfBirth;
		}

		public void setBabysPlaceOfBirth(Base babysPlaceOfBirth) {
			BabysPlaceOfBirth = babysPlaceOfBirth;
		}

		public Base getAddress() {
			return Address;
		}

		public void setAddress(Base address) {
			Address = address;
		}
		
	}
}
