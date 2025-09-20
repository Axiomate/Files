package com.heartbeat.controller;

import com.heartbeat.DTO.response.rsd.ResponseDTO;
import com.heartbeat.maternaldeath.MaternalDeathLogic;
import com.heartbeat.service.MaternalDeathService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.heartbeat.maternaldeath.MaternalDeathXmlModel.*;

@RestController
@RequestMapping("/maternal-death")
public class MaternalDeathController {

	@Autowired
	private MaternalDeathService maternalDeathService;
	@Autowired
	MaternalDeathLogic logic;

	@PostMapping("/save/{tab}")
	public ResponseEntity<String> insertRecord(@PathVariable String tab, @RequestBody String xmlData) {
		try {

			Object obj = logic.parseAndAssign(tab, xmlData);
			if (obj == null) {
				return ResponseEntity.badRequest().body("Invalid tab name: " + tab);
			}
			String id = invokeInsert(tab, obj);
			return ResponseEntity.ok(tab + " inserted successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error inserting " + tab + ": " + e.getMessage());
		}
	}

	@PutMapping("/update/{tab}")
	public ResponseEntity<String> updateRecord(@PathVariable String tab, @RequestBody String xmlData) {
		try {
			Object obj = logic.parseAndAssign(tab, xmlData);
			if (obj == null) {
				return ResponseEntity.badRequest().body("Invalid tab name: " + tab);
			}
			invokeUpdate(tab, obj);
			return ResponseEntity.ok(tab + " updated successfully.");
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error updating " + tab + ": " + e.getMessage());
		}
	}

	@GetMapping("/get/{tab}/{caseId}")
	public ResponseEntity<Object> selectRecord(@PathVariable String tab, @PathVariable String caseId) {
		try {
			Object result = invokeSelect(tab, caseId);
			if (result == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Error selecting " + tab + ": " + e.getMessage());
		}
	}

	@GetMapping("/generate-xml/{ipId}")
	public ResponseEntity<String> generateXmlFromInfantMortality(@PathVariable int ipId) {
		try {
			String result = maternalDeathService.generateXmlFromMaternalDeath(logic, ipId);
			if (result == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("Cannot generate XML " + e.getMessage());
		}
	}

	@GetMapping("/submit-xml/{ipId}")
	public ResponseEntity<ResponseDTO> submitXmlToInfantMortality(@PathVariable int ipId,
			@RequestParam(value = "userId", defaultValue = "0") String userId) {
		try {
			ResponseDTO result = maternalDeathService.submitMaternalDeathXmlToAPI(logic, ipId, userId);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			return ResponseEntity.status(500)
					.body(new ResponseDTO(false, "Cannot generate XML " + e.getMessage(), null));
		}
	}

	private String invokeInsert(String tab, Object obj) throws Exception {
		if ("EventDetails".equals(tab))
			maternalDeathService.insertEventDetails((EventDetails) obj);
		else if ("EventLocation".equals(tab))
			maternalDeathService.insertEventLocation((EventLocation) obj);
		else if ("IDENTIFICATION".equals(tab) || "Identification".equals(tab))
			maternalDeathService.insertIdentification((IDENTIFICATION) obj);
		else if ("ObstetricHistory".equals(tab))
			maternalDeathService.insertObstetricHistory((ObstetricHistory) obj);
		else if ("PreExistingMedicalConditions".equals(tab))
			maternalDeathService.insertPreExistingMedicalConditions((PreExistingMedicalConditions) obj);
		else if ("AntenatalRiskFactors".equals(tab))
			maternalDeathService.insertAntenatalRiskFactors((AntenatalRiskFactors) obj);
		else if ("LaboratoryTest".equals(tab))
			maternalDeathService.insertLaboratoryTest((LaboratoryTest) obj);
		else if ("PathwayBeforeAdmission".equals(tab))
			maternalDeathService.insertPathwayBeforeAdmission((PathwayBeforeAdmission) obj);
		else if ("Admission".equals(tab))
			maternalDeathService.insertAdmission((Admission) obj);
		else if ("VitalSigns".equals(tab))
			maternalDeathService.insertVitalSigns((VitalSigns) obj);
		else if ("AbdominalExamination".equals(tab))
			maternalDeathService.insertAbdominalExamination((AbdominalExamination) obj);
		else if ("PelvicExamination".equals(tab))
			maternalDeathService.insertPelvicExamination((PelvicExamination) obj);
		else if ("AdmissionComplications".equals(tab))
			maternalDeathService.insertAdmissionComplications((AdmissionComplications) obj);
		else if ("LabourAndBirth".equals(tab))
			maternalDeathService.insertLabourAndBirth((LabourAndBirth) obj);
		else if ("ApgarScore".equals(tab))
			maternalDeathService.insertApgarScore((ApgarScore) obj);
		else if ("EarlyPregnancy".equals(tab))
			maternalDeathService.insertEarlyPregnancy((EarlyPregnancy) obj);
		else if ("Antepartum".equals(tab))
			maternalDeathService.insertAntepartum((Antepartum) obj);
		else if ("Intrapartum".equals(tab))
			maternalDeathService.insertIntrapartum((Intrapartum) obj);
		else if ("Postpartum".equals(tab))
			maternalDeathService.insertPostpartum((Postpartum) obj);
		else if ("OtherInterventions".equals(tab))
			maternalDeathService.insertOtherInterventions((OtherInterventions) obj);
		else if ("DetailsOfTheDeath".equals(tab))
			maternalDeathService.insertDetailsOfTheDeath((DetailsOfTheDeath) obj);
		else if ("CriticalDelays".equals(tab))
			maternalDeathService.insertCriticalDelays((CriticalDelays) obj);
		else if ("ModifiableFactors".equals(tab))
			maternalDeathService.insertModifiableFactors((ModifiableFactors) obj);
		else if ("Formcompletedby".equals(tab))
			maternalDeathService.insertFormcompletedby((Formcompletedby) obj);
		else if ("ActionsAtHospitalLevel".equals(tab))
			maternalDeathService.insertActionsAtHospitalLevel((ActionsAtHospitalLevel) obj);
		else
			throw new IllegalArgumentException("Unsupported tab: " + tab);
		return tab;
	}

	private void invokeUpdate(String tab, Object obj) {
		if ("EventDetails".equals(tab))
			maternalDeathService.updateEventDetails((EventDetails) obj);
		else if ("EventLocation".equals(tab))
			maternalDeathService.updateEventLocation((EventLocation) obj);
		else if ("IDENTIFICATION".equals(tab) || "Identification".equals(tab))
			maternalDeathService.updateIdentification((IDENTIFICATION) obj);
		else if ("ObstetricHistory".equals(tab))
			maternalDeathService.updateObstetricHistory((ObstetricHistory) obj);
		else if ("PreExistingMedicalConditions".equals(tab))
			maternalDeathService.updatePreExistingMedicalConditions((PreExistingMedicalConditions) obj);
		else if ("AntenatalRiskFactors".equals(tab))
			maternalDeathService.updateAntenatalRiskFactors((AntenatalRiskFactors) obj);
		else if ("LaboratoryTest".equals(tab))
			maternalDeathService.updateLaboratoryTest((LaboratoryTest) obj);
		else if ("PathwayBeforeAdmission".equals(tab))
			maternalDeathService.updatePathwayBeforeAdmission((PathwayBeforeAdmission) obj);
		else if ("Admission".equals(tab))
			maternalDeathService.updateAdmission((Admission) obj);
		else if ("VitalSigns".equals(tab))
			maternalDeathService.updateVitalSigns((VitalSigns) obj);
		else if ("AbdominalExamination".equals(tab))
			maternalDeathService.updateAbdominalExamination((AbdominalExamination) obj);
		else if ("PelvicExamination".equals(tab))
			maternalDeathService.updatePelvicExamination((PelvicExamination) obj);
		else if ("AdmissionComplications".equals(tab))
			maternalDeathService.updateAdmissionComplications((AdmissionComplications) obj);
		else if ("LabourAndBirth".equals(tab))
			maternalDeathService.updateLabourAndBirth((LabourAndBirth) obj);
		else if ("ApgarScore".equals(tab))
			maternalDeathService.updateApgarScore((ApgarScore) obj);
		else if ("EarlyPregnancy".equals(tab))
			maternalDeathService.updateEarlyPregnancy((EarlyPregnancy) obj);
		else if ("Antepartum".equals(tab))
			maternalDeathService.updateAntepartum((Antepartum) obj);
		else if ("Intrapartum".equals(tab))
			maternalDeathService.updateIntrapartum((Intrapartum) obj);
		else if ("Postpartum".equals(tab))
			maternalDeathService.updatePostpartum((Postpartum) obj);
		else if ("OtherInterventions".equals(tab))
			maternalDeathService.updateOtherInterventions((OtherInterventions) obj);
		else if ("DetailsOfTheDeath".equals(tab))
			maternalDeathService.updateDetailsOfTheDeath((DetailsOfTheDeath) obj);
		else if ("CriticalDelays".equals(tab))
			maternalDeathService.updateCriticalDelays((CriticalDelays) obj);
		else if ("ModifiableFactors".equals(tab))
			maternalDeathService.updateModifiableFactors((ModifiableFactors) obj);
		else if ("Formcompletedby".equals(tab))
			maternalDeathService.updateFormcompletedby((Formcompletedby) obj);
		else if ("ActionsAtHospitalLevel".equals(tab))
			maternalDeathService.updateActionsAtHospitalLevel((ActionsAtHospitalLevel) obj);
		else
			throw new IllegalArgumentException("Unsupported tab: " + tab);
	}

	// --- SELECT ---
	private Object invokeSelect(String tab, String caseId) {
		int id = Integer.parseInt(caseId); // adjust if some sections should use ipId instead
		if ("EventDetails".equals(tab))
			return maternalDeathService.selectEventDetails(id);
		else if ("EventLocation".equals(tab))
			return maternalDeathService.selectEventLocation(id);
		else if ("IDENTIFICATION".equals(tab) || "Identification".equals(tab))
			return maternalDeathService.selectIdentification(id);
		else if ("ObstetricHistory".equals(tab))
			return maternalDeathService.selectObstetricHistory(id);
		else if ("PreExistingMedicalConditions".equals(tab))
			return maternalDeathService.selectPreExistingMedicalConditions(id);
		else if ("AntenatalRiskFactors".equals(tab))
			return maternalDeathService.selectAntenatalRiskFactors(id);
		else if ("LaboratoryTest".equals(tab))
			return maternalDeathService.selectLaboratoryTest(id);
		else if ("PathwayBeforeAdmission".equals(tab))
			return maternalDeathService.selectPathwayBeforeAdmission(id);
		else if ("Admission".equals(tab))
			return maternalDeathService.selectAdmission(id);
		else if ("VitalSigns".equals(tab))
			return maternalDeathService.selectVitalSigns(id);
		else if ("AbdominalExamination".equals(tab))
			return maternalDeathService.selectAbdominalExamination(id);
		else if ("PelvicExamination".equals(tab))
			return maternalDeathService.selectPelvicExamination(id);
		else if ("AdmissionComplications".equals(tab))
			return maternalDeathService.selectAdmissionComplications(id);
		else if ("LabourAndBirth".equals(tab))
			return maternalDeathService.selectLabourAndBirth(id);
		else if ("ApgarScore".equals(tab))
			return maternalDeathService.selectApgarScore(id);
		else if ("EarlyPregnancy".equals(tab))
			return maternalDeathService.selectEarlyPregnancy(id);
		else if ("Antepartum".equals(tab))
			return maternalDeathService.selectAntepartum(id);
		else if ("Intrapartum".equals(tab))
			return maternalDeathService.selectIntrapartum(id);
		else if ("Postpartum".equals(tab))
			return maternalDeathService.selectPostpartum(id);
		else if ("OtherInterventions".equals(tab))
			return maternalDeathService.selectOtherInterventions(id);
		else if ("DetailsOfTheDeath".equals(tab))
			return maternalDeathService.selectDetailsOfTheDeath(id);
		else if ("CriticalDelays".equals(tab))
			return maternalDeathService.selectCriticalDelays(id);
		else if ("ModifiableFactors".equals(tab))
			return maternalDeathService.selectModifiableFactors(id);
		else if ("Formcompletedby".equals(tab))
			return maternalDeathService.selectFormcompletedby(id);
		else if ("ActionsAtHospitalLevel".equals(tab))
			return maternalDeathService.selectActionsAtHospitalLevel(id);
		else
			throw new IllegalArgumentException("Unsupported tab: " + tab);
	}

}
