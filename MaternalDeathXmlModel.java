package com.heartbeat.maternaldeath;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

public class MaternalDeathXmlModel {

	// ================= Reusable leaf holder for <Tag value="..."/>
	// =================
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

	// ============================= Sections (inner classes)
	// =============================

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

	public static String camelToSnake(String str) {
		return str.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class EventDetails {
		public int eventDetailsId;
		public Base Domain;
		public Base HCFEventID;
		public Base EventOccurrenceDate;
		public Base EventOccurrenceTime;
		public Base EventSubmittedDate;
		public Base EventSubmittedTime;
		public Base EventUpdatedDate;
		public Base EventClosedDate;
		public Base EventRecordStatus;
		public Base CaseSummary;
		public Base NationalMpdsrCommitteeRecommendation;
		@JacksonXmlProperty(isAttribute = true)
		public int ipId;
		@JacksonXmlProperty(isAttribute = true)
		public int rehabBillId;

		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

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
			domain.setValue("Maternal");
			Domain = domain;
		}

		public Base getHCFEventID() {
			return HCFEventID;
		}

		public void setHCFEventID(Base HCFEventID) {
			this.HCFEventID = HCFEventID;
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

		public Base getCaseSummary() {
			return CaseSummary;
		}

		public void setCaseSummary(Base caseSummary) {
			CaseSummary = caseSummary;
		}

		public Base getNationalMpdsrCommitteeRecommendation() {
			return NationalMpdsrCommitteeRecommendation;
		}

		public void setNationalMpdsrCommitteeRecommendation(Base v) {
			NationalMpdsrCommitteeRecommendation = v;
		}
		
		public EventDetails() {
			Domain = new Base();
			Domain.setValue("Mortality");
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class EventLocation {
		public Base FacilityName;
		public Base FacilityMFID;
		public Base FacilityType;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getFacilityName() {
			return FacilityName;
		}

		public void setFacilityName(Base facilityName) {
			FacilityName = facilityName;
		}

		public Base getFacilityMFID() {
			return FacilityMFID;
		}

		public void setFacilityMFID(Base facilityMFID) {
			FacilityMFID = facilityMFID;
		}

		public Base getFacilityType() {
			return FacilityType;
		}

		public void setFacilityType(Base facilityType) {
			FacilityType = facilityType;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class IDENTIFICATION {
		public Base DeceasedMRNCMRN;
		public Base Deceasedfirstname;
		public Base Deceasedsecondname;
		public Base Deceasedlastname;
		public Base Deceasednationality;
		public Base DeceasedEmiratesIDpassportnumber;
		public Base DeceasedUAEresidencystatus;
		public Base AddressIfResidentandCitizen;
		public Base LengthofstayIfvisitor;
		public Base Paymentmethod;
		public Base OtherPaymentMethods;
		public Base DeathNotificationNumber;
		public Base DeceasedageYears;
		public Base Deceasededucation;
		public Base Deceasedoccupation;
		public Base DeceasedEmployedSpecify;
		public Base DeceasedMaritalstatus;
		public Base OtherMaritalStatus;
		public Base HusbandsOccupation;
		public Base HusbandEmployedSpecify;
		public Base Typeofcareavailable;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}
		public Base getDeceasedMRNCMRN() {
			return DeceasedMRNCMRN;
		}

		public void setDeceasedMRNCMRN(Base v) {
			DeceasedMRNCMRN = v;
		}

		public Base getDeceasedfirstname() {
			return Deceasedfirstname;
		}

		public void setDeceasedfirstname(Base v) {
			Deceasedfirstname = v;
		}

		public Base getDeceasedsecondname() {
			return Deceasedsecondname;
		}

		public void setDeceasedsecondname(Base v) {
			Deceasedsecondname = v;
		}

		public Base getDeceasedlastname() {
			return Deceasedlastname;
		}

		public void setDeceasedlastname(Base v) {
			Deceasedlastname = v;
		}

		public Base getDeceasednationality() {
			return Deceasednationality;
		}

		public void setDeceasednationality(Base v) {
			Deceasednationality = v;
		}

		public Base getDeceasedEmiratesIDpassportnumber() {
			return DeceasedEmiratesIDpassportnumber;
		}

		public void setDeceasedEmiratesIDpassportnumber(Base v) {
			DeceasedEmiratesIDpassportnumber = v;
		}

		public Base getDeceasedUAEresidencystatus() {
			return DeceasedUAEresidencystatus;
		}

		public void setDeceasedUAEresidencystatus(Base v) {
			DeceasedUAEresidencystatus = v;
		}

		public Base getAddressIfResidentandCitizen() {
			return AddressIfResidentandCitizen;
		}

		public void setAddressIfResidentandCitizen(Base v) {
			AddressIfResidentandCitizen = v;
		}

		public Base getLengthofstayIfvisitor() {
			return LengthofstayIfvisitor;
		}

		public void setLengthofstayIfvisitor(Base v) {
			LengthofstayIfvisitor = v;
		}

		public Base getPaymentmethod() {
			return Paymentmethod;
		}

		public void setPaymentmethod(Base v) {
			Paymentmethod = v;
		}

		public Base getOtherPaymentMethods() {
			return OtherPaymentMethods;
		}

		public void setOtherPaymentMethods(Base v) {
			OtherPaymentMethods = v;
		}

		public Base getDeathNotificationNumber() {
			return DeathNotificationNumber;
		}

		public void setDeathNotificationNumber(Base v) {
			DeathNotificationNumber = v;
		}

		public Base getDeceasedageYears() {
			return DeceasedageYears;
		}

		public void setDeceasedageYears(Base v) {
			DeceasedageYears = v;
		}

		public Base getDeceasededucation() {
			return Deceasededucation;
		}

		public void setDeceasededucation(Base v) {
			Deceasededucation = v;
		}

		public Base getDeceasedoccupation() {
			return Deceasedoccupation;
		}

		public void setDeceasedoccupation(Base v) {
			Deceasedoccupation = v;
		}

		public Base getDeceasedEmployedSpecify() {
			return DeceasedEmployedSpecify;
		}

		public void setDeceasedEmployedSpecify(Base v) {
			DeceasedEmployedSpecify = v;
		}

		public Base getDeceasedMaritalstatus() {
			return DeceasedMaritalstatus;
		}

		public void setDeceasedMaritalstatus(Base v) {
			DeceasedMaritalstatus = v;
		}

		public Base getOtherMaritalStatus() {
			return OtherMaritalStatus;
		}

		public void setOtherMaritalStatus(Base v) {
			OtherMaritalStatus = v;
		}

		public Base getHusbandsOccupation() {
			return HusbandsOccupation;
		}

		public void setHusbandsOccupation(Base v) {
			HusbandsOccupation = v;
		}

		public Base getHusbandEmployedSpecify() {
			return HusbandEmployedSpecify;
		}

		public void setHusbandEmployedSpecify(Base v) {
			HusbandEmployedSpecify = v;
		}

		public Base getTypeofcareavailable() {
			return Typeofcareavailable;
		}

		public void setTypeofcareavailable(Base v) {
			Typeofcareavailable = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ObstetricHistory {
		public Base Gravidity;
		public Base Parity;
		public Base Livebirths;
		public Base Stillbirths;
		public Base NeonatalDeaths;
		public Base InducedAbortion;
		public Base SpontaneousAbortion;
		public Base Previouscaesarean;
		public Base DateofrecentCS;
		public Base Previouspregnancycomplications;
		public Base PreviouspregnancyDate;
		public Base PreviouspregnancyNumber;
		public Base PreviouspregnancyDescription;
		public Base ContraceptionUseJustPriorToCurrentPregnancy;
		public Base Typeofpregnancy;
		public Base Bookingvisitat;
		public Base AntenatalCareNumberOfVisits;
		public Base DateoflastANCvisit;
		public Base ANCservicesprovidedat;
		public Base ANCprovidedby;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getGravidity() {
			return Gravidity;
		}

		public void setGravidity(Base v) {
			Gravidity = v;
		}

		public Base getParity() {
			return Parity;
		}

		public void setParity(Base v) {
			Parity = v;
		}

		public Base getLivebirths() {
			return Livebirths;
		}

		public void setLivebirths(Base v) {
			Livebirths = v;
		}

		public Base getStillbirths() {
			return Stillbirths;
		}

		public void setStillbirths(Base v) {
			Stillbirths = v;
		}

		public Base getNeonatalDeaths() {
			return NeonatalDeaths;
		}

		public void setNeonatalDeaths(Base v) {
			NeonatalDeaths = v;
		}

		public Base getInducedAbortion() {
			return InducedAbortion;
		}

		public void setInducedAbortion(Base v) {
			InducedAbortion = v;
		}

		public Base getSpontaneousAbortion() {
			return SpontaneousAbortion;
		}

		public void setSpontaneousAbortion(Base v) {
			SpontaneousAbortion = v;
		}

		public Base getPreviouscaesarean() {
			return Previouscaesarean;
		}

		public void setPreviouscaesarean(Base v) {
			Previouscaesarean = v;
		}

		public Base getDateofrecentCS() {
			return DateofrecentCS;
		}

		public void setDateofrecentCS(Base v) {
			DateofrecentCS = v;
		}

		public Base getPreviouspregnancycomplications() {
			return Previouspregnancycomplications;
		}

		public void setPreviouspregnancycomplications(Base v) {
			Previouspregnancycomplications = v;
		}

		public Base getPreviouspregnancyDate() {
			return PreviouspregnancyDate;
		}

		public void setPreviouspregnancyDate(Base v) {
			PreviouspregnancyDate = v;
		}

		public Base getPreviouspregnancyNumber() {
			return PreviouspregnancyNumber;
		}

		public void setPreviouspregnancyNumber(Base v) {
			PreviouspregnancyNumber = v;
		}

		public Base getPreviouspregnancyDescription() {
			return PreviouspregnancyDescription;
		}

		public void setPreviouspregnancyDescription(Base v) {
			PreviouspregnancyDescription = v;
		}

		public Base getContraceptionUseJustPriorToCurrentPregnancy() {
			return ContraceptionUseJustPriorToCurrentPregnancy;
		}

		public void setContraceptionUseJustPriorToCurrentPregnancy(Base v) {
			ContraceptionUseJustPriorToCurrentPregnancy = v;
		}

		public Base getTypeofpregnancy() {
			return Typeofpregnancy;
		}

		public void setTypeofpregnancy(Base v) {
			Typeofpregnancy = v;
		}

		public Base getBookingvisitat() {
			return Bookingvisitat;
		}

		public void setBookingvisitat(Base v) {
			Bookingvisitat = v;
		}

		public Base getAntenatalCareNumberOfVisits() {
			return AntenatalCareNumberOfVisits;
		}

		public void setAntenatalCareNumberOfVisits(Base v) {
			AntenatalCareNumberOfVisits = v;
		}

		public Base getDateoflastANCvisit() {
			return DateoflastANCvisit;
		}

		public void setDateoflastANCvisit(Base v) {
			DateoflastANCvisit = v;
		}

		public Base getANCservicesprovidedat() {
			return ANCservicesprovidedat;
		}

		public void setANCservicesprovidedat(Base v) {
			ANCservicesprovidedat = v;
		}

		public Base getANCprovidedby() {
			return ANCprovidedby;
		}

		public void setANCprovidedby(Base v) {
			ANCprovidedby = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PreExistingMedicalConditions {
		public Base Hypertension;
		public Base Diabetes;
		public Base DiabetesOther;
		public Base Anemia;
		public Base Hepatitis;
		public Base Heartproblem;
		public Base Mentaldisorder;
		public Base InfectiousDiseases;
		public Base Otherdiseases;
		public Base OtherSpecifyPreExistingMedicalConditions;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}
		public Base getHypertension() {
			return Hypertension;
		}

		public void setHypertension(Base v) {
			Hypertension = v;
		}

		public Base getDiabetes() {
			return Diabetes;
		}

		public void setDiabetes(Base v) {
			Diabetes = v;
		}

		public Base getDiabetesOther() {
			return DiabetesOther;
		}

		public void setDiabetesOther(Base v) {
			DiabetesOther = v;
		}

		public Base getAnemia() {
			return Anemia;
		}

		public void setAnemia(Base v) {
			Anemia = v;
		}

		public Base getHepatitis() {
			return Hepatitis;
		}

		public void setHepatitis(Base v) {
			Hepatitis = v;
		}

		public Base getHeartproblem() {
			return Heartproblem;
		}

		public void setHeartproblem(Base v) {
			Heartproblem = v;
		}

		public Base getMentaldisorder() {
			return Mentaldisorder;
		}

		public void setMentaldisorder(Base v) {
			Mentaldisorder = v;
		}

		public Base getInfectiousDiseases() {
			return InfectiousDiseases;
		}

		public void setInfectiousDiseases(Base v) {
			InfectiousDiseases = v;
		}

		public Base getOtherdiseases() {
			return Otherdiseases;
		}

		public void setOtherdiseases(Base v) {
			Otherdiseases = v;
		}

		public Base getOtherSpecifyPreExistingMedicalConditions() {
			return OtherSpecifyPreExistingMedicalConditions;
		}

		public void setOtherSpecifyPreExistingMedicalConditions(Base v) {
			OtherSpecifyPreExistingMedicalConditions = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class AntenatalRiskFactors {
		public Base Hypertension;
		public Base Proteinuria;
		public Base Glycosuria;
		public Base Anemia;
		public Base UrinaryTractInfection;
		public Base PlacentaPraevia;
		public Base PlacentaAccreta;
		public Base OtherSpecifyAntenatalRiskFactors;
		public Base AntenatalHospitalization;
		public Base DescribeAntenatalhospitalization;
		public Base AntenatalImmunization;
		public Base DescribeAntenatalimmunization;
		public Base AntenatalMedications;
		public Base ListtheMedications;
		public Base AntenatalSupplement;
		public Base ListSupplement;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getHypertension() {
			return Hypertension;
		}

		public void setHypertension(Base v) {
			Hypertension = v;
		}

		public Base getProteinuria() {
			return Proteinuria;
		}

		public void setProteinuria(Base v) {
			Proteinuria = v;
		}

		public Base getGlycosuria() {
			return Glycosuria;
		}

		public void setGlycosuria(Base v) {
			Glycosuria = v;
		}

		public Base getAnemia() {
			return Anemia;
		}

		public void setAnemia(Base v) {
			Anemia = v;
		}

		public Base getUrinaryTractInfection() {
			return UrinaryTractInfection;
		}

		public void setUrinaryTractInfection(Base v) {
			UrinaryTractInfection = v;
		}

		public Base getPlacentaPraevia() {
			return PlacentaPraevia;
		}

		public void setPlacentaPraevia(Base v) {
			PlacentaPraevia = v;
		}

		public Base getPlacentaAccreta() {
			return PlacentaAccreta;
		}

		public void setPlacentaAccreta(Base v) {
			PlacentaAccreta = v;
		}

		public Base getOtherSpecifyAntenatalRiskFactors() {
			return OtherSpecifyAntenatalRiskFactors;
		}

		public void setOtherSpecifyAntenatalRiskFactors(Base v) {
			OtherSpecifyAntenatalRiskFactors = v;
		}

		public Base getAntenatalHospitalization() {
			return AntenatalHospitalization;
		}

		public void setAntenatalHospitalization(Base v) {
			AntenatalHospitalization = v;
		}

		public Base getDescribeAntenatalhospitalization() {
			return DescribeAntenatalhospitalization;
		}

		public void setDescribeAntenatalhospitalization(Base v) {
			DescribeAntenatalhospitalization = v;
		}

		public Base getAntenatalImmunization() {
			return AntenatalImmunization;
		}

		public void setAntenatalImmunization(Base v) {
			AntenatalImmunization = v;
		}

		public Base getDescribeAntenatalimmunization() {
			return DescribeAntenatalimmunization;
		}

		public void setDescribeAntenatalimmunization(Base v) {
			DescribeAntenatalimmunization = v;
		}

		public Base getAntenatalMedications() {
			return AntenatalMedications;
		}

		public void setAntenatalMedications(Base v) {
			AntenatalMedications = v;
		}

		public Base getListtheMedications() {
			return ListtheMedications;
		}

		public void setListtheMedications(Base v) {
			ListtheMedications = v;
		}

		public Base getAntenatalSupplement() {
			return AntenatalSupplement;
		}

		public void setAntenatalSupplement(Base v) {
			AntenatalSupplement = v;
		}

		public Base getListSupplement() {
			return ListSupplement;
		}

		public void setListSupplement(Base v) {
			ListSupplement = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class LaboratoryTest {
		public Base BloodTypeAndRH;
		public Base BloodTypeAndRHSpecify;
		public Base HematocritHemoglobin;
		public Base HematocritHemoglobinSpecify;
		public Base VDRL;
		public Base VDRLSpecify;
		public Base Rubella;
		public Base RubellaSpecify;
		public Base Urinalysis;
		public Base UrinalysisSpecify;
		public Base HIV;
		public Base HIVSpecify;
		public Base HBsAg;
		public Base HBsAgSpecify;
		public Base FGTTHemoglobinA1c;
		public Base FGTTHemoglobinA1cSpecify;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getBloodTypeAndRH() {
			return BloodTypeAndRH;
		}

		public void setBloodTypeAndRH(Base v) {
			BloodTypeAndRH = v;
		}

		public Base getBloodTypeAndRHSpecify() {
			return BloodTypeAndRHSpecify;
		}

		public void setBloodTypeAndRHSpecify(Base v) {
			BloodTypeAndRHSpecify = v;
		}

		public Base getHematocritHemoglobin() {
			return HematocritHemoglobin;
		}

		public void setHematocritHemoglobin(Base v) {
			HematocritHemoglobin = v;
		}

		public Base getHematocritHemoglobinSpecify() {
			return HematocritHemoglobinSpecify;
		}

		public void setHematocritHemoglobinSpecify(Base v) {
			HematocritHemoglobinSpecify = v;
		}

		public Base getVDRL() {
			return VDRL;
		}

		public void setVDRL(Base v) {
			VDRL = v;
		}

		public Base getVDRLSpecify() {
			return VDRLSpecify;
		}

		public void setVDRLSpecify(Base v) {
			VDRLSpecify = v;
		}

		public Base getRubella() {
			return Rubella;
		}

		public void setRubella(Base v) {
			Rubella = v;
		}

		public Base getRubellaSpecify() {
			return RubellaSpecify;
		}

		public void setRubellaSpecify(Base v) {
			RubellaSpecify = v;
		}

		public Base getUrinalysis() {
			return Urinalysis;
		}

		public void setUrinalysis(Base v) {
			Urinalysis = v;
		}

		public Base getUrinalysisSpecify() {
			return UrinalysisSpecify;
		}

		public void setUrinalysisSpecify(Base v) {
			UrinalysisSpecify = v;
		}

		public Base getHIV() {
			return HIV;
		}

		public void setHIV(Base v) {
			HIV = v;
		}

		public Base getHIVSpecify() {
			return HIVSpecify;
		}

		public void setHIVSpecify(Base v) {
			HIVSpecify = v;
		}

		public Base getHBsAg() {
			return HBsAg;
		}

		public void setHBsAg(Base v) {
			HBsAg = v;
		}

		public Base getHBsAgSpecify() {
			return HBsAgSpecify;
		}

		public void setHBsAgSpecify(Base v) {
			HBsAgSpecify = v;
		}

		public Base getFGTTHemoglobinA1c() {
			return FGTTHemoglobinA1c;
		}

		public void setFGTTHemoglobinA1c(Base v) {
			FGTTHemoglobinA1c = v;
		}

		public Base getFGTTHemoglobinA1cSpecify() {
			return FGTTHemoglobinA1cSpecify;
		}

		public void setFGTTHemoglobinA1cSpecify(Base v) {
			FGTTHemoglobinA1cSpecify = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PathwayBeforeAdmission {
		public Base Modeofarrival;
		public Base Referredfrom;
		public Base Reasonsforreferral;
		public Base Prereferralmanagement;
		public Base Accompanyingperson;
		public Base AccompanyingpersonSpecify;
		public Base DateOfOnsetSymptomsKnown;
		public Base Dateofonsetofsymptoms;
		public Base Timeofonsetofsymptoms;
		public Base DateOfTheReferralDecisionKnown;
		public Base DateOfTheReferralDecision;
		public Base TimeOfTheReferralDecision;
		public Base DateOfTransferFromTheReferralCenterKnown;
		public Base DateOfTransferFromTheReferralCenter;
		public Base TimeOfTransferFromTheReferralCenter;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getModeofarrival() {
			return Modeofarrival;
		}

		public void setModeofarrival(Base v) {
			Modeofarrival = v;
		}

		public Base getReferredfrom() {
			return Referredfrom;
		}

		public void setReferredfrom(Base v) {
			Referredfrom = v;
		}

		public Base getReasonsforreferral() {
			return Reasonsforreferral;
		}

		public void setReasonsforreferral(Base v) {
			Reasonsforreferral = v;
		}

		public Base getPrereferralmanagement() {
			return Prereferralmanagement;
		}

		public void setPrereferralmanagement(Base v) {
			Prereferralmanagement = v;
		}

		public Base getAccompanyingperson() {
			return Accompanyingperson;
		}

		public void setAccompanyingperson(Base v) {
			Accompanyingperson = v;
		}

		public Base getAccompanyingpersonSpecify() {
			return AccompanyingpersonSpecify;
		}

		public void setAccompanyingpersonSpecify(Base v) {
			AccompanyingpersonSpecify = v;
		}

		public Base getDateOfOnsetSymptomsKnown() {
			return DateOfOnsetSymptomsKnown;
		}

		public void setDateOfOnsetSymptomsKnown(Base v) {
			DateOfOnsetSymptomsKnown = v;
		}

		public Base getDateofonsetofsymptoms() {
			return Dateofonsetofsymptoms;
		}

		public void setDateofonsetofsymptoms(Base v) {
			Dateofonsetofsymptoms = v;
		}

		public Base getTimeofonsetofsymptoms() {
			return Timeofonsetofsymptoms;
		}

		public void setTimeofonsetofsymptoms(Base v) {
			Timeofonsetofsymptoms = v;
		}

		public Base getDateOfTheReferralDecisionKnown() {
			return DateOfTheReferralDecisionKnown;
		}

		public void setDateOfTheReferralDecisionKnown(Base v) {
			DateOfTheReferralDecisionKnown = v;
		}

		public Base getDateOfTheReferralDecision() {
			return DateOfTheReferralDecision;
		}

		public void setDateOfTheReferralDecision(Base v) {
			DateOfTheReferralDecision = v;
		}

		public Base getTimeOfTheReferralDecision() {
			return TimeOfTheReferralDecision;
		}

		public void setTimeOfTheReferralDecision(Base v) {
			TimeOfTheReferralDecision = v;
		}

		public Base getDateOfTransferFromTheReferralCenterKnown() {
			return DateOfTransferFromTheReferralCenterKnown;
		}

		public void setDateOfTransferFromTheReferralCenterKnown(Base v) {
			DateOfTransferFromTheReferralCenterKnown = v;
		}

		public Base getDateOfTransferFromTheReferralCenter() {
			return DateOfTransferFromTheReferralCenter;
		}

		public void setDateOfTransferFromTheReferralCenter(Base v) {
			DateOfTransferFromTheReferralCenter = v;
		}

		public Base getTimeOfTransferFromTheReferralCenter() {
			return TimeOfTransferFromTheReferralCenter;
		}

		public void setTimeOfTransferFromTheReferralCenter(Base v) {
			TimeOfTransferFromTheReferralCenter = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Admission {
		public Base DateOfAdmissionKnown;
		public Base DateOfAdmission;
		public Base TimeOfAdmission;
		public Base MainReasonChiefComplaintForAdmission;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getDateOfAdmissionKnown() {
			return DateOfAdmissionKnown;
		}

		public void setDateOfAdmissionKnown(Base v) {
			DateOfAdmissionKnown = v;
		}

		public Base getDateOfAdmission() {
			return DateOfAdmission;
		}

		public void setDateOfAdmission(Base v) {
			DateOfAdmission = v;
		}

		public Base getTimeOfAdmission() {
			return TimeOfAdmission;
		}

		public void setTimeOfAdmission(Base v) {
			TimeOfAdmission = v;
		}

		public Base getMainReasonChiefComplaintForAdmission() {
			return MainReasonChiefComplaintForAdmission;
		}

		public void setMainReasonChiefComplaintForAdmission(Base v) {
			MainReasonChiefComplaintForAdmission = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class VitalSigns {
		public Base Heartrate;
		public Base Systolicbloodpressure;
		public Base Diastolicbloodpressure;
		public Base TempCelsius;
		public Base Respiratoryrate;
		public Base Height;
		public Base Weight;
		public Base OtherSpecify;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getHeartrate() {
			return Heartrate;
		}

		public void setHeartrate(Base v) {
			Heartrate = v;
		}

		public Base getSystolicbloodpressure() {
			return Systolicbloodpressure;
		}

		public void setSystolicbloodpressure(Base v) {
			Systolicbloodpressure = v;
		}

		public Base getDiastolicbloodpressure() {
			return Diastolicbloodpressure;
		}

		public void setDiastolicbloodpressure(Base v) {
			Diastolicbloodpressure = v;
		}

		public Base getTempCelsius() {
			return TempCelsius;
		}

		public void setTempCelsius(Base v) {
			TempCelsius = v;
		}

		public Base getRespiratoryrate() {
			return Respiratoryrate;
		}

		public void setRespiratoryrate(Base v) {
			Respiratoryrate = v;
		}

		public Base getHeight() {
			return Height;
		}

		public void setHeight(Base v) {
			Height = v;
		}

		public Base getWeight() {
			return Weight;
		}

		public void setWeight(Base v) {
			Weight = v;
		}

		public Base getOtherSpecify() {
			return OtherSpecify;
		}

		public void setOtherSpecify(Base v) {
			OtherSpecify = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class AbdominalExamination {
		public Base Fundalheight;
		public Base FetalHeartSoundsOnAdmission;
		public Base FetalHeartSoundsOnAdmissionIfPresent;
		public Base FetalPresentation;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getFundalheight() {
			return Fundalheight;
		}

		public void setFundalheight(Base v) {
			Fundalheight = v;
		}

		public Base getFetalHeartSoundsOnAdmission() {
			return FetalHeartSoundsOnAdmission;
		}

		public void setFetalHeartSoundsOnAdmission(Base v) {
			FetalHeartSoundsOnAdmission = v;
		}

		public Base getFetalHeartSoundsOnAdmissionIfPresent() {
			return FetalHeartSoundsOnAdmissionIfPresent;
		}

		public void setFetalHeartSoundsOnAdmissionIfPresent(Base v) {
			FetalHeartSoundsOnAdmissionIfPresent = v;
		}

		public Base getFetalPresentation() {
			return FetalPresentation;
		}

		public void setFetalPresentation(Base v) {
			FetalPresentation = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class PelvicExamination {
		public Base StageofLabour;
		public Base PelvicAbnormality;
		public Base PelvicabnormalityifYesDescribe;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getStageofLabour() {
			return StageofLabour;
		}

		public void setStageofLabour(Base v) {
			StageofLabour = v;
		}

		public Base getPelvicAbnormality() {
			return PelvicAbnormality;
		}

		public void setPelvicAbnormality(Base v) {
			PelvicAbnormality = v;
		}

		public Base getPelvicabnormalityifYesDescribe() {
			return PelvicabnormalityifYesDescribe;
		}

		public void setPelvicabnormalityifYesDescribe(Base v) {
			PelvicabnormalityifYesDescribe = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class AdmissionComplications {
		public Base PrelabourRuptureOfMembranes;
		public Base PreEclampsia;
		public Base Eclampsia;
		public Base Abruption;
		public Base PlacentaPraevia;
		public Base PretermLabour;
		public Base FetalDemise;
		public Base Sepsis;
		public Base OtherSpecifyAdmissioncomplications;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getPrelabourRuptureOfMembranes() {
			return PrelabourRuptureOfMembranes;
		}

		public void setPrelabourRuptureOfMembranes(Base v) {
			PrelabourRuptureOfMembranes = v;
		}

		public Base getPreEclampsia() {
			return PreEclampsia;
		}

		public void setPreEclampsia(Base v) {
			PreEclampsia = v;
		}

		public Base getEclampsia() {
			return Eclampsia;
		}

		public void setEclampsia(Base v) {
			Eclampsia = v;
		}

		public Base getAbruption() {
			return Abruption;
		}

		public void setAbruption(Base v) {
			Abruption = v;
		}

		public Base getPlacentaPraevia() {
			return PlacentaPraevia;
		}

		public void setPlacentaPraevia(Base v) {
			PlacentaPraevia = v;
		}

		public Base getPretermLabour() {
			return PretermLabour;
		}

		public void setPretermLabour(Base v) {
			PretermLabour = v;
		}

		public Base getFetalDemise() {
			return FetalDemise;
		}

		public void setFetalDemise(Base v) {
			FetalDemise = v;
		}

		public Base getSepsis() {
			return Sepsis;
		}

		public void setSepsis(Base v) {
			Sepsis = v;
		}

		public Base getOtherSpecifyAdmissioncomplications() {
			return OtherSpecifyAdmissioncomplications;
		}

		public void setOtherSpecifyAdmissioncomplications(Base v) {
			OtherSpecifyAdmissioncomplications = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class LabourAndBirth {
		public Base LMP;
		public Base DateLMPknown;
		public Base Dateofdelivery;
		public Base Timeofdelivery;
		public Base GestationalAge;
		public Base Methodofestimationofgestationalage;
		public Base Placeofdelivery;
		public Base OtherPlaceofdelivery;
		public Base Attendedby;
		public Base AttendedbyOther;
		public Base OnsetOfLabour;
		public Base PartogramUsed;
		public Base Complicationsoflabourandbirth;
		public Base ModeOfDelivery;
		public Base OtherModeofdelivery;
		public Base TypeOfAnaesthesiaGivenToMother;
		public Base DurationOfLabour;
		public Base FetalHeartSoundsOnAdmission;
		public Base FetalheartsoundPresent;
		public Base IntrapartumHemorrhage;
		public Base IntrapartumInfection;
		public Base Intrapartumpreeclampsiaeclampsia;
		public Base Obstructedlabour;
		public Base OtherSpecifyComplicationsoflabourandbirth;
		public Base TimeBetweenActionDecisionAndBirth;
		public Base ActiveManagementOfThirdStage;
		public Base RetainedPlacenta;
		public Base PostpartumHemorrhage;
		public Base PostpartumInfection;
		public Base PostpartumPreEclampsiaEclampsia;
		public Base NumberOfPNCorPACVisits;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getLMP() {
			return LMP;
		}

		public void setLMP(Base v) {
			LMP = v;
		}

		public Base getDateLMPknown() {
			return DateLMPknown;
		}

		public void setDateLMPknown(Base v) {
			DateLMPknown = v;
		}

		public Base getDateofdelivery() {
			return Dateofdelivery;
		}

		public void setDateofdelivery(Base v) {
			Dateofdelivery = v;
		}

		public Base getTimeofdelivery() {
			return Timeofdelivery;
		}

		public void setTimeofdelivery(Base v) {
			Timeofdelivery = v;
		}

		public Base getGestationalAge() {
			return GestationalAge;
		}

		public void setGestationalAge(Base v) {
			GestationalAge = v;
		}

		public Base getMethodofestimationofgestationalage() {
			return Methodofestimationofgestationalage;
		}

		public void setMethodofestimationofgestationalage(Base v) {
			Methodofestimationofgestationalage = v;
		}

		public Base getPlaceofdelivery() {
			return Placeofdelivery;
		}

		public void setPlaceofdelivery(Base v) {
			Placeofdelivery = v;
		}

		public Base getOtherPlaceofdelivery() {
			return OtherPlaceofdelivery;
		}

		public void setOtherPlaceofdelivery(Base v) {
			OtherPlaceofdelivery = v;
		}

		public Base getAttendedby() {
			return Attendedby;
		}

		public void setAttendedby(Base v) {
			Attendedby = v;
		}

		public Base getAttendedbyOther() {
			return AttendedbyOther;
		}

		public void setAttendedbyOther(Base v) {
			AttendedbyOther = v;
		}

		public Base getOnsetOfLabour() {
			return OnsetOfLabour;
		}

		public void setOnsetOfLabour(Base v) {
			OnsetOfLabour = v;
		}

		public Base getPartogramUsed() {
			return PartogramUsed;
		}

		public void setPartogramUsed(Base v) {
			PartogramUsed = v;
		}

		public Base getComplicationsoflabourandbirth() {
			return Complicationsoflabourandbirth;
		}

		public void setComplicationsoflabourandbirth(Base v) {
			Complicationsoflabourandbirth = v;
		}

		public Base getModeOfDelivery() {
			return ModeOfDelivery;
		}

		public void setModeOfDelivery(Base v) {
			ModeOfDelivery = v;
		}

		public Base getOtherModeofdelivery() {
			return OtherModeofdelivery;
		}

		public void setOtherModeofdelivery(Base v) {
			OtherModeofdelivery = v;
		}

		public Base getTypeOfAnaesthesiaGivenToMother() {
			return TypeOfAnaesthesiaGivenToMother;
		}

		public void setTypeOfAnaesthesiaGivenToMother(Base v) {
			TypeOfAnaesthesiaGivenToMother = v;
		}

		public Base getDurationOfLabour() {
			return DurationOfLabour;
		}

		public void setDurationOfLabour(Base v) {
			DurationOfLabour = v;
		}

		public Base getFetalHeartSoundsOnAdmission() {
			return FetalHeartSoundsOnAdmission;
		}

		public void setFetalHeartSoundsOnAdmission(Base v) {
			FetalHeartSoundsOnAdmission = v;
		}

		public Base getFetalheartsoundPresent() {
			return FetalheartsoundPresent;
		}

		public void setFetalheartsoundPresent(Base v) {
			FetalheartsoundPresent = v;
		}

		public Base getIntrapartumHemorrhage() {
			return IntrapartumHemorrhage;
		}

		public void setIntrapartumHemorrhage(Base v) {
			IntrapartumHemorrhage = v;
		}

		public Base getIntrapartumInfection() {
			return IntrapartumInfection;
		}

		public void setIntrapartumInfection(Base v) {
			IntrapartumInfection = v;
		}

		public Base getIntrapartumpreeclampsiaeclampsia() {
			return Intrapartumpreeclampsiaeclampsia;
		}

		public void setIntrapartumpreeclampsiaeclampsia(Base v) {
			Intrapartumpreeclampsiaeclampsia = v;
		}

		public Base getObstructedlabour() {
			return Obstructedlabour;
		}

		public void setObstructedlabour(Base v) {
			Obstructedlabour = v;
		}

		public Base getOtherSpecifyComplicationsoflabourandbirth() {
			return OtherSpecifyComplicationsoflabourandbirth;
		}

		public void setOtherSpecifyComplicationsoflabourandbirth(Base v) {
			OtherSpecifyComplicationsoflabourandbirth = v;
		}

		public Base getTimeBetweenActionDecisionAndBirth() {
			return TimeBetweenActionDecisionAndBirth;
		}

		public void setTimeBetweenActionDecisionAndBirth(Base v) {
			TimeBetweenActionDecisionAndBirth = v;
		}

		public Base getActiveManagementOfThirdStage() {
			return ActiveManagementOfThirdStage;
		}

		public void setActiveManagementOfThirdStage(Base v) {
			ActiveManagementOfThirdStage = v;
		}

		public Base getRetainedPlacenta() {
			return RetainedPlacenta;
		}

		public void setRetainedPlacenta(Base v) {
			RetainedPlacenta = v;
		}

		public Base getPostpartumHemorrhage() {
			return PostpartumHemorrhage;
		}

		public void setPostpartumHemorrhage(Base v) {
			PostpartumHemorrhage = v;
		}

		public Base getPostpartumInfection() {
			return PostpartumInfection;
		}

		public void setPostpartumInfection(Base v) {
			PostpartumInfection = v;
		}

		public Base getPostpartumPreEclampsiaEclampsia() {
			return PostpartumPreEclampsiaEclampsia;
		}

		public void setPostpartumPreEclampsiaEclampsia(Base v) {
			PostpartumPreEclampsiaEclampsia = v;
		}

		public Base getNumberOfPNCorPACVisits() {
			return NumberOfPNCorPACVisits;
		}

		public void setNumberOfPNCorPACVisits(Base v) {
			NumberOfPNCorPACVisits = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ApgarScore {
		public Base ApgarScore1;
		public Base ApgarScore5;
		public Base ApgarScore10;
		public Base Resuscitation;
		public Base OtherResuscitation;
		public Base SexOfBaby;
		public Base BirthWeight;
		public Base SpecifyTheExactWeight;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getApgarScore1() {
			return ApgarScore1;
		}

		public void setApgarScore1(Base v) {
			ApgarScore1 = v;
		}

		public Base getApgarScore5() {
			return ApgarScore5;
		}

		public void setApgarScore5(Base v) {
			ApgarScore5 = v;
		}

		public Base getApgarScore10() {
			return ApgarScore10;
		}

		public void setApgarScore10(Base v) {
			ApgarScore10 = v;
		}

		public Base getResuscitation() {
			return Resuscitation;
		}

		public void setResuscitation(Base v) {
			Resuscitation = v;
		}

		public Base getOtherResuscitation() {
			return OtherResuscitation;
		}

		public void setOtherResuscitation(Base v) {
			OtherResuscitation = v;
		}

		public Base getSexOfBaby() {
			return SexOfBaby;
		}

		public void setSexOfBaby(Base v) {
			SexOfBaby = v;
		}

		public Base getBirthWeight() {
			return BirthWeight;
		}

		public void setBirthWeight(Base v) {
			BirthWeight = v;
		}

		public Base getSpecifyTheExactWeight() {
			return SpecifyTheExactWeight;
		}

		public void setSpecifyTheExactWeight(Base v) {
			SpecifyTheExactWeight = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class EarlyPregnancy {
		public Base Evacuation;
		public Base Laparotomy;
		public Base Hysterotomy;
		public Base Transfusion;
		public Base OtherEarlypregnancy;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getEvacuation() {
			return Evacuation;
		}

		public void setEvacuation(Base v) {
			Evacuation = v;
		}

		public Base getLaparotomy() {
			return Laparotomy;
		}

		public void setLaparotomy(Base v) {
			Laparotomy = v;
		}

		public Base getHysterotomy() {
			return Hysterotomy;
		}

		public void setHysterotomy(Base v) {
			Hysterotomy = v;
		}

		public Base getTransfusion() {
			return Transfusion;
		}

		public void setTransfusion(Base v) {
			Transfusion = v;
		}

		public Base getOtherEarlypregnancy() {
			return OtherEarlypregnancy;
		}

		public void setOtherEarlypregnancy(Base v) {
			OtherEarlypregnancy = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Antepartum {
		public Base Transfusion;
		public Base Version;
		public Base LabourInduction;
		public Base MagnesiumSulfate;
		public Base Antibiotics;
		public Base OtherAntepartum;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getTransfusion() {
			return Transfusion;
		}

		public void setTransfusion(Base v) {
			Transfusion = v;
		}

		public Base getVersion() {
			return Version;
		}

		public void setVersion(Base v) {
			Version = v;
		}

		public Base getLabourInduction() {
			return LabourInduction;
		}

		public void setLabourInduction(Base v) {
			LabourInduction = v;
		}

		public Base getMagnesiumSulfate() {
			return MagnesiumSulfate;
		}

		public void setMagnesiumSulfate(Base v) {
			MagnesiumSulfate = v;
		}

		public Base getAntibiotics() {
			return Antibiotics;
		}

		public void setAntibiotics(Base v) {
			Antibiotics = v;
		}

		public Base getOtherAntepartum() {
			return OtherAntepartum;
		}

		public void setOtherAntepartum(Base v) {
			OtherAntepartum = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Intrapartum {
		public Base Hysterectomy;
		public Base Transfusion;
		public Base MagnesiumSulfate;
		public Base Antibiotics;
		public Base DestructiveOperations;
		public Base OtherIntrapartum;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getHysterectomy() {
			return Hysterectomy;
		}

		public void setHysterectomy(Base v) {
			Hysterectomy = v;
		}

		public Base getTransfusion() {
			return Transfusion;
		}

		public void setTransfusion(Base v) {
			Transfusion = v;
		}

		public Base getMagnesiumSulfate() {
			return MagnesiumSulfate;
		}

		public void setMagnesiumSulfate(Base v) {
			MagnesiumSulfate = v;
		}

		public Base getAntibiotics() {
			return Antibiotics;
		}

		public void setAntibiotics(Base v) {
			Antibiotics = v;
		}

		public Base getDestructiveOperations() {
			return DestructiveOperations;
		}

		public void setDestructiveOperations(Base v) {
			DestructiveOperations = v;
		}

		public Base getOtherIntrapartum() {
			return OtherIntrapartum;
		}

		public void setOtherIntrapartum(Base v) {
			OtherIntrapartum = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Postpartum {
		public Base Evacuation;
		public Base Laparotomy;
		public Base Hysterotomy;
		public Base Hysterectomy;
		public Base Transfusion;
		public Base MagnesiumSulfate;
		public Base Antibiotics;
		public Base Oxytocin;
		public Base Misoprostol;
		public Base OthersPostpartum;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getEvacuation() {
			return Evacuation;
		}

		public void setEvacuation(Base v) {
			Evacuation = v;
		}

		public Base getLaparotomy() {
			return Laparotomy;
		}

		public void setLaparotomy(Base v) {
			Laparotomy = v;
		}

		public Base getHysterotomy() {
			return Hysterotomy;
		}

		public void setHysterotomy(Base v) {
			Hysterotomy = v;
		}

		public Base getHysterectomy() {
			return Hysterectomy;
		}

		public void setHysterectomy(Base v) {
			Hysterectomy = v;
		}

		public Base getTransfusion() {
			return Transfusion;
		}

		public void setTransfusion(Base v) {
			Transfusion = v;
		}

		public Base getMagnesiumSulfate() {
			return MagnesiumSulfate;
		}

		public void setMagnesiumSulfate(Base v) {
			MagnesiumSulfate = v;
		}

		public Base getAntibiotics() {
			return Antibiotics;
		}

		public void setAntibiotics(Base v) {
			Antibiotics = v;
		}

		public Base getOxytocin() {
			return Oxytocin;
		}

		public void setOxytocin(Base v) {
			Oxytocin = v;
		}

		public Base getMisoprostol() {
			return Misoprostol;
		}

		public void setMisoprostol(Base v) {
			Misoprostol = v;
		}

		public Base getOthersPostpartum() {
			return OthersPostpartum;
		}

		public void setOthersPostpartum(Base v) {
			OthersPostpartum = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class OtherInterventions {
		public Base GeneralAnesthesia;
		public Base Epidural;
		public Base Spinal;
		public Base Local;
		public Base ICUventilation;
		public Base InvasiveMonitoring;
		public Base AntenatalSteroid;
		public Base OtherInterventions;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getGeneralAnesthesia() {
			return GeneralAnesthesia;
		}

		public void setGeneralAnesthesia(Base v) {
			GeneralAnesthesia = v;
		}

		public Base getEpidural() {
			return Epidural;
		}

		public void setEpidural(Base v) {
			Epidural = v;
		}

		public Base getSpinal() {
			return Spinal;
		}

		public void setSpinal(Base v) {
			Spinal = v;
		}

		public Base getLocal() {
			return Local;
		}

		public void setLocal(Base v) {
			Local = v;
		}

		public Base getICUventilation() {
			return ICUventilation;
		}

		public void setICUventilation(Base v) {
			ICUventilation = v;
		}

		public Base getInvasiveMonitoring() {
			return InvasiveMonitoring;
		}

		public void setInvasiveMonitoring(Base v) {
			InvasiveMonitoring = v;
		}

		public Base getAntenatalSteroid() {
			return AntenatalSteroid;
		}

		public void setAntenatalSteroid(Base v) {
			AntenatalSteroid = v;
		}

		public Base getOtherInterventions() {
			return OtherInterventions;
		}

		public void setOtherInterventions(Base v) {
			OtherInterventions = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DetailsOfTheDeath {
		public Base Dateofdeath;
		public Base Timeofdeath;
		public Base WhenDeathOccurred;
		public Base PregnancyStatusAttimeOfDeath;
		public Base PregnancyStatusAttimeOfDeathOthers;
		public Base Ifpostpartumpostabortiondeathhowmanydaysafterdeliveryabortiondeathoccurred;
		public Base DirectCauseOfDeathICDMM;
		public Base UnderlyingCauseOfDeathICDMM;
		public Base Contributorycausesofdeath;
		public Base AdditionalDetailsifApplicable;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getDateofdeath() {
			return Dateofdeath;
		}

		public void setDateofdeath(Base v) {
			Dateofdeath = v;
		}

		public Base getTimeofdeath() {
			return Timeofdeath;
		}

		public void setTimeofdeath(Base v) {
			Timeofdeath = v;
		}

		public Base getWhenDeathOccurred() {
			return WhenDeathOccurred;
		}

		public void setWhenDeathOccurred(Base v) {
			WhenDeathOccurred = v;
		}

		public Base getPregnancyStatusAttimeOfDeath() {
			return PregnancyStatusAttimeOfDeath;
		}

		public void setPregnancyStatusAttimeOfDeath(Base v) {
			PregnancyStatusAttimeOfDeath = v;
		}

		public Base getPregnancyStatusAttimeOfDeathOthers() {
			return PregnancyStatusAttimeOfDeathOthers;
		}

		public void setPregnancyStatusAttimeOfDeathOthers(Base v) {
			PregnancyStatusAttimeOfDeathOthers = v;
		}

		public Base getIfpostpartumpostabortiondeathhowmanydaysafterdeliveryabortiondeathoccurred() {
			return Ifpostpartumpostabortiondeathhowmanydaysafterdeliveryabortiondeathoccurred;
		}

		public void setIfpostpartumpostabortiondeathhowmanydaysafterdeliveryabortiondeathoccurred(Base v) {
			Ifpostpartumpostabortiondeathhowmanydaysafterdeliveryabortiondeathoccurred = v;
		}

		public Base getDirectCauseOfDeathICDMM() {
			return DirectCauseOfDeathICDMM;
		}

		public void setDirectCauseOfDeathICDMM(Base v) {
			DirectCauseOfDeathICDMM = v;
		}

		public Base getUnderlyingCauseOfDeathICDMM() {
			return UnderlyingCauseOfDeathICDMM;
		}

		public void setUnderlyingCauseOfDeathICDMM(Base v) {
			UnderlyingCauseOfDeathICDMM = v;
		}

		public Base getContributorycausesofdeath() {
			return Contributorycausesofdeath;
		}

		public void setContributorycausesofdeath(Base v) {
			Contributorycausesofdeath = v;
		}

		public Base getAdditionalDetailsifApplicable() {
			return AdditionalDetailsifApplicable;
		}

		public void setAdditionalDetailsifApplicable(Base v) {
			AdditionalDetailsifApplicable = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class CriticalDelays {
		public Base Delay1inseekingcare;
		public Base Delay1Identify;
		public Base Delay2inreachingfacility;
		public Base Delay2Identify;
		public Base Delay3withinhealthcarefacility;
		public Base Delay3Identify;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getDelay1inseekingcare() {
			return Delay1inseekingcare;
		}

		public void setDelay1inseekingcare(Base v) {
			Delay1inseekingcare = v;
		}

		public Base getDelay1Identify() {
			return Delay1Identify;
		}

		public void setDelay1Identify(Base v) {
			Delay1Identify = v;
		}

		public Base getDelay2inreachingfacility() {
			return Delay2inreachingfacility;
		}

		public void setDelay2inreachingfacility(Base v) {
			Delay2inreachingfacility = v;
		}

		public Base getDelay2Identify() {
			return Delay2Identify;
		}

		public void setDelay2Identify(Base v) {
			Delay2Identify = v;
		}

		public Base getDelay3withinhealthcarefacility() {
			return Delay3withinhealthcarefacility;
		}

		public void setDelay3withinhealthcarefacility(Base v) {
			Delay3withinhealthcarefacility = v;
		}

		public Base getDelay3Identify() {
			return Delay3Identify;
		}

		public void setDelay3Identify(Base v) {
			Delay3Identify = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ModifiableFactors {
		public Base FamilyRelated;
		public Base FamilyRelatedIdentify;
		public Base AdministrationRelated;
		public Base AdministrationRelatedIdentify;
		public Base ProviderRelated;
		public Base ProviderRelatedIdentify;
		public Base OthersModifiablefactor;
		public Base Actiontoaddressthecriticaldelaysandmodifiablefactors;
		public Base WasTheDeathPreventable;
		public Base FurtherComments;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getFamilyRelated() {
			return FamilyRelated;
		}

		public void setFamilyRelated(Base v) {
			FamilyRelated = v;
		}

		public Base getFamilyRelatedIdentify() {
			return FamilyRelatedIdentify;
		}

		public void setFamilyRelatedIdentify(Base v) {
			FamilyRelatedIdentify = v;
		}

		public Base getAdministrationRelated() {
			return AdministrationRelated;
		}

		public void setAdministrationRelated(Base v) {
			AdministrationRelated = v;
		}

		public Base getAdministrationRelatedIdentify() {
			return AdministrationRelatedIdentify;
		}

		public void setAdministrationRelatedIdentify(Base v) {
			AdministrationRelatedIdentify = v;
		}

		public Base getProviderRelated() {
			return ProviderRelated;
		}

		public void setProviderRelated(Base v) {
			ProviderRelated = v;
		}

		public Base getProviderRelatedIdentify() {
			return ProviderRelatedIdentify;
		}

		public void setProviderRelatedIdentify(Base v) {
			ProviderRelatedIdentify = v;
		}

		public Base getOthersModifiablefactor() {
			return OthersModifiablefactor;
		}

		public void setOthersModifiablefactor(Base v) {
			OthersModifiablefactor = v;
		}

		public Base getActiontoaddressthecriticaldelaysandmodifiablefactors() {
			return Actiontoaddressthecriticaldelaysandmodifiablefactors;
		}

		public void setActiontoaddressthecriticaldelaysandmodifiablefactors(Base v) {
			Actiontoaddressthecriticaldelaysandmodifiablefactors = v;
		}

		public Base getWasTheDeathPreventable() {
			return WasTheDeathPreventable;
		}

		public void setWasTheDeathPreventable(Base v) {
			WasTheDeathPreventable = v;
		}

		public Base getFurtherComments() {
			return FurtherComments;
		}

		public void setFurtherComments(Base v) {
			FurtherComments = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Formcompletedby {
		public Base Name;
		public Base Email;
		public Base DateofReview;
		public Base TimeofReview;
		public Base Designation;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getName() {
			return Name;
		}

		public void setName(Base v) {
			Name = v;
		}

		public Base getEmail() {
			return Email;
		}

		public void setEmail(Base v) {
			Email = v;
		}

		public Base getDateofReview() {
			return DateofReview;
		}

		public void setDateofReview(Base v) {
			DateofReview = v;
		}

		public Base getTimeofReview() {
			return TimeofReview;
		}

		public void setTimeofReview(Base v) {
			TimeofReview = v;
		}

		public Base getDesignation() {
			return Designation;
		}

		public void setDesignation(Base v) {
			Designation = v;
		}
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class ActionsAtHospitalLevel {
		public Base ActionrecommendedbytheMandMreviewcommittee;
		public Base Date;
		public Base ChairpersonNameORmpdsrSignature;
		public Base Email;
		public Base Contactnumber;
		public int eventDetailsId;	
		
		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public Base getActionrecommendedbytheMandMreviewcommittee() {
			return ActionrecommendedbytheMandMreviewcommittee;
		}

		public void setActionrecommendedbytheMandMreviewcommittee(Base v) {
			ActionrecommendedbytheMandMreviewcommittee = v;
		}

		public Base getDate() {
			return Date;
		}

		public void setDate(Base v) {
			Date = v;
		}

		public Base getChairpersonNameORmpdsrSignature() {
			return ChairpersonNameORmpdsrSignature;
		}

		public void setChairpersonNameORmpdsrSignature(Base v) {
			ChairpersonNameORmpdsrSignature = v;
		}

		public Base getEmail() {
			return Email;
		}

		public void setEmail(Base v) {
			Email = v;
		}

		public Base getContactnumber() {
			return Contactnumber;
		}

		public void setContactnumber(Base v) {
			Contactnumber = v;
		}
	}

	// ============================ Top-level fields ============================

	public EventDetails EventDetails;
	public EventLocation EventLocation;
	public IDENTIFICATION IDENTIFICATION;
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

	// ============================ Getters/Setters top-level
	// ============================
	public EventDetails getEventDetails() {
		return EventDetails;
	}

	public void setEventDetails(EventDetails eventDetails) {
		EventDetails = eventDetails;
	}

	public EventLocation getEventLocation() {
		return EventLocation;
	}

	public void setEventLocation(EventLocation eventLocation) {
		EventLocation = eventLocation;
	}

	public IDENTIFICATION getIDENTIFICATION() {
		return IDENTIFICATION;
	}

	public void setIDENTIFICATION(IDENTIFICATION IDENTIFICATION) {
		this.IDENTIFICATION = IDENTIFICATION;
	}

	public ObstetricHistory getObstetricHistory() {
		return ObstetricHistory;
	}

	public void setObstetricHistory(ObstetricHistory obstetricHistory) {
		ObstetricHistory = obstetricHistory;
	}

	public PreExistingMedicalConditions getPreExistingMedicalConditions() {
		return PreExistingMedicalConditions;
	}

	public void setPreExistingMedicalConditions(PreExistingMedicalConditions v) {
		PreExistingMedicalConditions = v;
	}

	public AntenatalRiskFactors getAntenatalRiskFactors() {
		return AntenatalRiskFactors;
	}

	public void setAntenatalRiskFactors(AntenatalRiskFactors v) {
		AntenatalRiskFactors = v;
	}

	public LaboratoryTest getLaboratoryTest() {
		return LaboratoryTest;
	}

	public void setLaboratoryTest(LaboratoryTest v) {
		LaboratoryTest = v;
	}

	public PathwayBeforeAdmission getPathwayBeforeAdmission() {
		return PathwayBeforeAdmission;
	}

	public void setPathwayBeforeAdmission(PathwayBeforeAdmission v) {
		PathwayBeforeAdmission = v;
	}

	public Admission getAdmission() {
		return Admission;
	}

	public void setAdmission(Admission admission) {
		Admission = admission;
	}

	public VitalSigns getVitalSigns() {
		return VitalSigns;
	}

	public void setVitalSigns(VitalSigns vitalSigns) {
		VitalSigns = vitalSigns;
	}

	public AbdominalExamination getAbdominalExamination() {
		return AbdominalExamination;
	}

	public void setAbdominalExamination(AbdominalExamination v) {
		AbdominalExamination = v;
	}

	public PelvicExamination getPelvicExamination() {
		return PelvicExamination;
	}

	public void setPelvicExamination(PelvicExamination v) {
		PelvicExamination = v;
	}

	public AdmissionComplications getAdmissionComplications() {
		return AdmissionComplications;
	}

	public void setAdmissionComplications(AdmissionComplications v) {
		AdmissionComplications = v;
	}

	public LabourAndBirth getLabourAndBirth() {
		return LabourAndBirth;
	}

	public void setLabourAndBirth(LabourAndBirth v) {
		LabourAndBirth = v;
	}

	public ApgarScore getApgarScore() {
		return ApgarScore;
	}

	public void setApgarScore(ApgarScore apgarScore) {
		ApgarScore = apgarScore;
	}

	public EarlyPregnancy getEarlyPregnancy() {
		return EarlyPregnancy;
	}

	public void setEarlyPregnancy(EarlyPregnancy v) {
		EarlyPregnancy = v;
	}

	public Antepartum getAntepartum() {
		return Antepartum;
	}

	public void setAntepartum(Antepartum v) {
		Antepartum = v;
	}

	public Intrapartum getIntrapartum() {
		return Intrapartum;
	}

	public void setIntrapartum(Intrapartum v) {
		Intrapartum = v;
	}

	public Postpartum getPostpartum() {
		return Postpartum;
	}

	public void setPostpartum(Postpartum v) {
		Postpartum = v;
	}

	public OtherInterventions getOtherInterventions() {
		return OtherInterventions;
	}

	public void setOtherInterventions(OtherInterventions v) {
		OtherInterventions = v;
	}

	public DetailsOfTheDeath getDetailsOfTheDeath() {
		return DetailsOfTheDeath;
	}

	public void setDetailsOfTheDeath(DetailsOfTheDeath v) {
		DetailsOfTheDeath = v;
	}

	public CriticalDelays getCriticalDelays() {
		return CriticalDelays;
	}

	public void setCriticalDelays(CriticalDelays v) {
		CriticalDelays = v;
	}

	public ModifiableFactors getModifiableFactors() {
		return ModifiableFactors;
	}

	public void setModifiableFactors(ModifiableFactors v) {
		ModifiableFactors = v;
	}

	public Formcompletedby getFormcompletedby() {
		return Formcompletedby;
	}

	public void setFormcompletedby(Formcompletedby v) {
		Formcompletedby = v;
	}

	public ActionsAtHospitalLevel getActionsAtHospitalLevel() {
		return ActionsAtHospitalLevel;
	}

	public void setActionsAtHospitalLevel(ActionsAtHospitalLevel v) {
		ActionsAtHospitalLevel = v;
	}

	@JacksonXmlRootElement(localName = "Root")
	public static class MaternalDeathData {
		public int eventDetailsId;
		public int dateFormatForXmlGeneration;
		public EventDetails EventDetails;
		public EventLocation EventLocation;
		public IDENTIFICATION IDENTIFICATION;
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

		public int getEventDetailsId() {
			return eventDetailsId;
		}

		public void setEventDetailsId(int eventDetailsId) {
			this.eventDetailsId = eventDetailsId;
		}

		public int getDateFormatForXmlGeneration() {
			return dateFormatForXmlGeneration;
		}

		public void setDateFormatForXmlGeneration(int dateFormatForXmlGeneration) {
			this.dateFormatForXmlGeneration = dateFormatForXmlGeneration;
		}

		public EventDetails getEventDetails() {
			return EventDetails;
		}

		public void setEventDetails(EventDetails v) {
			EventDetails = v;
		}

		public EventLocation getEventLocation() {
			return EventLocation;
		}

		public void setEventLocation(EventLocation v) {
			EventLocation = v;
		}

		public IDENTIFICATION getIDENTIFICATION() {
			return IDENTIFICATION;
		}

		public void setIDENTIFICATION(IDENTIFICATION v) {
			IDENTIFICATION = v;
		}

		public ObstetricHistory getObstetricHistory() {
			return ObstetricHistory;
		}

		public void setObstetricHistory(ObstetricHistory v) {
			ObstetricHistory = v;
		}

		public PreExistingMedicalConditions getPreExistingMedicalConditions() {
			return PreExistingMedicalConditions;
		}

		public void setPreExistingMedicalConditions(PreExistingMedicalConditions v) {
			PreExistingMedicalConditions = v;
		}

		public AntenatalRiskFactors getAntenatalRiskFactors() {
			return AntenatalRiskFactors;
		}

		public void setAntenatalRiskFactors(AntenatalRiskFactors v) {
			AntenatalRiskFactors = v;
		}

		public LaboratoryTest getLaboratoryTest() {
			return LaboratoryTest;
		}

		public void setLaboratoryTest(LaboratoryTest v) {
			LaboratoryTest = v;
		}

		public PathwayBeforeAdmission getPathwayBeforeAdmission() {
			return PathwayBeforeAdmission;
		}

		public void setPathwayBeforeAdmission(PathwayBeforeAdmission v) {
			PathwayBeforeAdmission = v;
		}

		public Admission getAdmission() {
			return Admission;
		}

		public void setAdmission(Admission v) {
			Admission = v;
		}

		public VitalSigns getVitalSigns() {
			return VitalSigns;
		}

		public void setVitalSigns(VitalSigns v) {
			VitalSigns = v;
		}

		public AbdominalExamination getAbdominalExamination() {
			return AbdominalExamination;
		}

		public void setAbdominalExamination(AbdominalExamination v) {
			AbdominalExamination = v;
		}

		public PelvicExamination getPelvicExamination() {
			return PelvicExamination;
		}

		public void setPelvicExamination(PelvicExamination v) {
			PelvicExamination = v;
		}

		public AdmissionComplications getAdmissionComplications() {
			return AdmissionComplications;
		}

		public void setAdmissionComplications(AdmissionComplications v) {
			AdmissionComplications = v;
		}

		public LabourAndBirth getLabourAndBirth() {
			return LabourAndBirth;
		}

		public void setLabourAndBirth(LabourAndBirth v) {
			LabourAndBirth = v;
		}

		public ApgarScore getApgarScore() {
			return ApgarScore;
		}

		public void setApgarScore(ApgarScore v) {
			ApgarScore = v;
		}

		public EarlyPregnancy getEarlyPregnancy() {
			return EarlyPregnancy;
		}

		public void setEarlyPregnancy(EarlyPregnancy v) {
			EarlyPregnancy = v;
		}

		public Antepartum getAntepartum() {
			return Antepartum;
		}

		public void setAntepartum(Antepartum v) {
			Antepartum = v;
		}

		public Intrapartum getIntrapartum() {
			return Intrapartum;
		}

		public void setIntrapartum(Intrapartum v) {
			Intrapartum = v;
		}

		public Postpartum getPostpartum() {
			return Postpartum;
		}

		public void setPostpartum(Postpartum v) {
			Postpartum = v;
		}

		public OtherInterventions getOtherInterventions() {
			return OtherInterventions;
		}

		public void setOtherInterventions(OtherInterventions v) {
			OtherInterventions = v;
		}

		public DetailsOfTheDeath getDetailsOfTheDeath() {
			return DetailsOfTheDeath;
		}

		public void setDetailsOfTheDeath(DetailsOfTheDeath v) {
			DetailsOfTheDeath = v;
		}

		public CriticalDelays getCriticalDelays() {
			return CriticalDelays;
		}

		public void setCriticalDelays(CriticalDelays v) {
			CriticalDelays = v;
		}

		public ModifiableFactors getModifiableFactors() {
			return ModifiableFactors;
		}

		public void setModifiableFactors(ModifiableFactors v) {
			ModifiableFactors = v;
		}

		public Formcompletedby getFormcompletedby() {
			return Formcompletedby;
		}

		public void setFormcompletedby(Formcompletedby v) {
			Formcompletedby = v;
		}

		public ActionsAtHospitalLevel getActionsAtHospitalLevel() {
			return ActionsAtHospitalLevel;
		}

		public void setActionsAtHospitalLevel(ActionsAtHospitalLevel v) {
			ActionsAtHospitalLevel = v;
		}
	}
}
