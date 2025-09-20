package com.heartbeat.controller;


import com.heartbeat.DTO.response.rsd.ResponseDTO;
import com.heartbeat.infantmortality.InfantMortalityXmlModel.*;
import com.heartbeat.infantmortality.InfantMortatlityLogic;
import com.heartbeat.service.InfantMortalityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/infant-mortality")
public class InfantMortalityController {

    @Autowired
    private InfantMortalityService infantMortalityService;
    @Autowired
    InfantMortatlityLogic logic;

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
            InfantMortatlityLogic logic = new InfantMortatlityLogic();
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
            String result = infantMortalityService.generateXmlFromInfantMortality(logic, ipId);
            if (result == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Cannot generate XML " + e.getMessage());
        }
    }
    
    @GetMapping("/submit-xml/{ipId}")
    public ResponseEntity<ResponseDTO> submitXmlToInfantMortality(@PathVariable int ipId,@RequestParam(value = "userId", defaultValue = "0") String userId) {
        try {
            ResponseDTO result = infantMortalityService.submitInfantMortalityXmltoAPI(logic, ipId,userId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseDTO(false, "Cannot generate XML " + e.getMessage(), null));
        }
    }

    private String invokeInsert(String tab, Object obj) throws Exception {
        if (tab.equals("MainDet")) infantMortalityService.insertMainDet((MainDet) obj);
        else if (tab.equals("PBA")) infantMortalityService.insertPBA((PBA) obj);
        else if (tab.equals("ADM")) infantMortalityService.insertADM((ADM) obj);
        else if (tab.equals("PEMC")) infantMortalityService.insertPEMC((PEMC) obj);
        else if (tab.equals("ARF")) infantMortalityService.insertARF((ARF) obj);
        else if (tab.equals("ARFO")) infantMortalityService.insertARFO((ARFO) obj);
        else if (tab.equals("LAB")) infantMortalityService.insertLAB((LAB) obj);
        else if (tab.equals("CLB")) infantMortalityService.insertCLB((CLB) obj);
        else if (tab.equals("ASD")) infantMortalityService.insertASD((ASD) obj);
        else if (tab.equals("OH")) infantMortalityService.insertOH((OH) obj);
        else if (tab.equals("OHO")) infantMortalityService.insertOHO((OHO) obj);
        else if (tab.equals("RESCUDET")) infantMortalityService.insertRESCUDET((RESCUDET) obj);
        else if (tab.equals("RESCUDETOTHR")) infantMortalityService.insertRESCUDETOTHR((RESCUDETOTHR) obj);
        else if (tab.equals("POSTHIS")) infantMortalityService.insertPOSTHIS((POSTHIS) obj);
        else if (tab.equals("DETOFDETH")) infantMortalityService.insertDETOFDETH((DETOFDETH) obj);
        else if (tab.equals("CRITDELY")) infantMortalityService.insertCRITDELY((CRITDELY) obj);
        else if (tab.equals("MODFACT")) infantMortalityService.insertMODFACT((MODFACT) obj);
        else if (tab.equals("MODFACTOTHR")) infantMortalityService.insertMODFACTOTHR((MODFACTOTHR) obj);
        else if (tab.equals("NAS")) infantMortalityService.insertNAS((NAS) obj);
        else if (tab.equals("ACTLEVLFAC")) infantMortalityService.insertACTLEVLFAC((ACTLEVLFAC) obj);
        else if (tab.equals("CASSUMM")) infantMortalityService.insertCASSUMM((CASSUMM) obj);
        else if (tab.equals("PATDET")) infantMortalityService.insertPATDET((PATDET) obj);
        else throw new IllegalArgumentException("Unsupported tab: " + tab);
		return tab;
    }

    private void invokeUpdate(String tab, Object obj) throws Exception {
        if (tab.equals("MainDet")) infantMortalityService.updateMainDet((MainDet) obj);
        else if (tab.equals("PBA")) infantMortalityService.updatePBA((PBA) obj);
        else if (tab.equals("ADM")) infantMortalityService.updateADM((ADM) obj);
        else if (tab.equals("PEMC")) infantMortalityService.updatePEMC((PEMC) obj);
        else if (tab.equals("ARF")) infantMortalityService.updateARF((ARF) obj);
        else if (tab.equals("ARFO")) infantMortalityService.updateARFO((ARFO) obj);
        else if (tab.equals("LAB")) infantMortalityService.updateLAB((LAB) obj);
        else if (tab.equals("CLB")) infantMortalityService.updateCLB((CLB) obj);
        else if (tab.equals("ASD")) infantMortalityService.updateASD((ASD) obj);
        else if (tab.equals("OH")) infantMortalityService.updateOH((OH) obj);
        else if (tab.equals("OHO")) infantMortalityService.updateOHO((OHO) obj);
        else if (tab.equals("RESCUDET")) infantMortalityService.updateRESCUDET((RESCUDET) obj);
        else if (tab.equals("RESCUDETOTHR")) infantMortalityService.updateRESCUDETOTHR((RESCUDETOTHR) obj);
        else if (tab.equals("POSTHIS")) infantMortalityService.updatePOSTHIS((POSTHIS) obj);
        else if (tab.equals("DETOFDETH")) infantMortalityService.updateDETOFDETH((DETOFDETH) obj);
        else if (tab.equals("CRITDELY")) infantMortalityService.updateCRITDELY((CRITDELY) obj);
        else if (tab.equals("MODFACT")) infantMortalityService.updateMODFACT((MODFACT) obj);
        else if (tab.equals("MODFACTOTHR")) infantMortalityService.updateMODFACTOTHR((MODFACTOTHR) obj);
        else if (tab.equals("NAS")) infantMortalityService.updateNAS((NAS) obj);
        else if (tab.equals("ACTLEVLFAC")) infantMortalityService.updateACTLEVLFAC((ACTLEVLFAC) obj);
        else if (tab.equals("CASSUMM")) infantMortalityService.updateCASSUMM((CASSUMM) obj);
        else if (tab.equals("PATDET")) infantMortalityService.updatePATDET((PATDET) obj);
        else throw new IllegalArgumentException("Unsupported tab: " + tab);
    }

    private Object invokeSelect(String tab, String caseId) throws Exception {
        if (tab.equals("MainDet")) return infantMortalityService.selectMainDet(Integer.parseInt(caseId));
        else if (tab.equals("PBA")) return infantMortalityService.selectPBA(Integer.parseInt(caseId));
        else if (tab.equals("ADM")) return infantMortalityService.selectADM(Integer.parseInt(caseId));
        else if (tab.equals("PEMC")) return infantMortalityService.selectPEMC(Integer.parseInt(caseId));
        else if (tab.equals("ARF")) return infantMortalityService.selectARF(Integer.parseInt(caseId));
        else if (tab.equals("ARFO")) return infantMortalityService.selectARFO(Integer.parseInt(caseId));
        else if (tab.equals("LAB")) return infantMortalityService.selectLAB(Integer.parseInt(caseId));
        else if (tab.equals("CLB")) return infantMortalityService.selectCLB(Integer.parseInt(caseId));
        else if (tab.equals("ASD")) return infantMortalityService.selectASD(Integer.parseInt(caseId));
        else if (tab.equals("OH")) return infantMortalityService.selectOH(Integer.parseInt(caseId));
        else if (tab.equals("OHO")) return infantMortalityService.selectOHO(Integer.parseInt(caseId));
        else if (tab.equals("RESCUDET")) return infantMortalityService.selectRESCUDET(Integer.parseInt(caseId));
        else if (tab.equals("RESCUDETOTHR")) return infantMortalityService.selectRESCUDETOTHR(Integer.parseInt(caseId));
        else if (tab.equals("POSTHIS")) return infantMortalityService.selectPOSTHIS(Integer.parseInt(caseId));
        else if (tab.equals("DETOFDETH")) return infantMortalityService.selectDETOFDETH(Integer.parseInt(caseId));
        else if (tab.equals("CRITDELY")) return infantMortalityService.selectCRITDELY(Integer.parseInt(caseId));
        else if (tab.equals("MODFACT")) return infantMortalityService.selectMODFACT(Integer.parseInt(caseId));
        else if (tab.equals("MODFACTOTHR")) return infantMortalityService.selectMODFACTOTHR(Integer.parseInt(caseId));
        else if (tab.equals("NAS")) return infantMortalityService.selectNAS(Integer.parseInt(caseId));
        else if (tab.equals("ACTLEVLFAC")) return infantMortalityService.selectACTLEVLFAC(Integer.parseInt(caseId));
        else if (tab.equals("CASSUMM")) return infantMortalityService.selectCASSUMM(Integer.parseInt(caseId));
        else if (tab.equals("PATDET")) return infantMortalityService.selectPATDET(Integer.parseInt(caseId));
        else throw new IllegalArgumentException("Unsupported tab: " + tab);
    }
}
