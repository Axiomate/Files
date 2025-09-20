package com.heartbeat.infantmortality;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InfantMortalityModel {
	
	// MainDet
	private String id;
	private String event_occurrence_date;
	private String event_occurrence_time;
	private String event_submitted_date;
	private String event_submitted_time;
	private String event_updated_date;
	private String facility_regions;
	private String facility_city;
	private String health_care_facility_name;
	private String facility_mfid;
	private String facility_group;
	private String facility_type;
	private String hcf_event_id;
	
	//PBA
	private String transreferred;
	private String reasons_for_referral;
	private String pre_referral_management;
	private String ambulance;
	private String medicines_and_health_on_board;
	private String medicines_and_health_on_board_specify;
	//private String AccompanyingPerson;
	private String date_of_onset_of_symptoms;
	private String time_of_onset_of_symptoms;
	private String date_of_referral_decision;
	private String time_of_referral_decision;
	//private String DateOfTransferFromReferralCenter;
	//private String TimeOfTransferFromReferralCenter;
	private String death_notification_number;
	
	// ADM
	private String date_of_admission;
	private String time_of_admission;
	private String main_reason_complaint_for_admission;
	
	// PEMC
	private String pemc_hypertension;
	private String diabetes;
	private String pemc_anemia;
	//private String Hepatitis;
	//private String HeartProblem;
	private String mental_disorder;
	private String infectious_diseases;
	private String other_pre_existing_medical_conditions;
	private String other_infectious_diseases;
	
	// ARF
	private String arf_hypertension;
	private String proteinuria;
	//private String Lycosuria;
	private String arf_anemia;
	//private String Lycosuria;
	private String urinary_tract_infection;
	private String placenta_praevia;
	private String placenta_accreta;
	private String group_b_streptococcus;
	private String other_antenatal_risk_factors;
	
	// ARFO
	private String antenatal_hospitalization;
	private String antenatal_hospitalization_other;
	private String antenatal_immunization;
	private String antenatal_immunization_other;
	private String antenatal_medications;
	private String antenatal_medications_list;
	private String antenatal_supplement;
	private String antenatal_supplement_list;
	
	// LAB
	private String colour_of_aniotic_fluid;
	private String amniotic_fluid_smell_offensive;
	private String decision_to_delivery_interval;
	private String total_duration_of_rupture_of_membrane;
	private String date_mothers_lmp;
	private String mothers_lmp;
	private String date_of_birth;
	private String gestational_age;
	private String method_of_estimation_of_gestational_age;
	private String place_of_childbirth;
	private String other_place_of_childbirth;
	private String attendant_at_childbirth;
	private String onset_of_labour;
	//private String Induced;
	private String partogram_used;
	private String mode_of_delivery;
	//private String OtherModeOfDelivery;
	private String type_of_anaesthesia_given_to_mother;
	private String duration_of_labour;
	private String onset_of_membrane_rupture;
	private String time_of_birth;
	
	// CLB
	private String intrapartum_hemorrhage;
	private String intrapartum_infection;
	private String c_intrapartum_pre_eclampsia;
	private String c_obstructed_labour;
	private String ruptured_uterus;
	private String c_cord_prolapse;
	private String c_mal_presentation;
	//private String OtherComplicationsOfLabourBirth;
	
	// CLBO
	//private String ProblemExperiencedInDelivery;
	private String maneuvers;
	private String other_maneuvers;
	
	// ASD
	private String apgar_score_1_min;
	private String apgar_score_5_min;
	private String apgar_score_10_min;
	
	// OH
	private String gravidity;
	private String parity;
	private String live_births;
	private String stillbirths;
	private String spontaneous_abortions;
	private String induced_abortion;
	
	// OHO
	private String previous_cesarean_sections;
	private String number;
	private String date_of_most_recents_cs;
	private String previous_pregnancy_complications;
	private String description;
	private String contraception_use_just_prior_to_current_pregnancy;
	private String type_of_contraception_use_just_prior_to_current_pregnancy;
	private String assisted_reproductive_therapy;
	private String type_of_assisted_reproductive_therapy;
	private String congenital_malformation_detected_in_antenatal;
	//private String WhatInterventionsWereTaken;
	private String type_of_pregnancy;
	//private String NumberOfPregnancy;
	private String booking_visit_at;
	private String antenatal_care_number_of_visits;
	private String date_of_last_anc_visit;
	private String anc_services_provided_at;
	//private String OtherANCServicesProvidedAt;
	//private String ANCProvidedBy;
	//private String ANCProvidedByOther;
	//private String Number;
	
	// RESCUDET
	private String resuscitation;
	private String other_resuscitation;
	//private String PassiveCooling;
	////private String TherapeuticCooling;
	//private String TimeOfDecision;
	private String type_of_death;
	private String date_of_death;
	//private String HoursCooled;
	private String time_of_death;
	//private String LengthOfResuscitation;
	
	// RESCUDETOTHR
	private String gender_of_baby;
	private String birth_weight;
	private String length;
	private String head_circumference;
	private String coded_birth_weight;
	//private String BirthCentile;
	
	// POSTHIS
	private String type_of_care_received;
	//private String DangerSigns;
	//private String OtherDangerSigns;
	private String medical_conditions;
	private String other_medical_conditions;
	//private String DidBabyReceivedAnyTreatmentBeforeDeath;
	//private String BabyReceivedAnyTreatmentBeforeDeath;
	
	// DETOFDETH
	//private String EnterTheCauseOfDeathAsPerICD10;
	private String underlying_cause;
	//private String ContributingConditions;
	//private String MainMaternalCondition;
	
	// CRITDELY
	private String critical_delays;
	private String delay_1_in_seeking_care;
	private String other_delay_1_in_seeking_care;
	private String delay_2_in_reaching_facility;
	private String other_delay_2_in_reaching_facility;
	private String delay_3_within_health_facility;
	private String other_delay_3_within_health_facility;
	
	// MODFACT
	private String modifiable_factors;
	private String family_related;
	private String other_family_related;
	private String adminstation_related;
	private String other_adminstation_related;
	private String provider_related;
	private String other_provider_related;
	//private String Others;
	
	// MODFACTOTHR
	private String was_the_death_preventable;
	private String action_to_address_the_critical_delays_and_modifiable_factors;
	
	// NAS
	private String form_completed_by;
	//private String Sign;
	//private String Designation;
	//private String Email;
	//private String DateOfReview;
	//private String TimeOfReview;
	
	// ACTLEVLFAC
	private String immediate_action_taken;
	private String action_recommended_from_the_mm_review_committee;
	private String hospital_m_and_m_review_committee_chairperson_name;
	private String date;
	private String signature;
	private String email;
	private String contact_number;
	
	// CASSUMM
	private String any_additional_notes;
	
	// PATDET
	private String mother_mrn;
	private String mother_emid_pass_id;
	private String mother_fname;
	private String mother_lname;
	private String mothers_nationality;
	private String mother_dob;
	private String mothers_education;
	private String mothers_occupation;
	private String mothers_occupation_specify;
	private String marital_status;
	private String type_of_mothers_insurance;
	//private String TypeOfMothersInsuranceOther;
	private String consanguineous_marriage;
	private String fathers_employment_status;
	private String fathers_employment_employed_other;
	private String fathers_nationality;
	private String father_smoker;
	private String mother_smoker;
	private String deceased_babys_full_name;
	private String deceased_babys_date_of_birth;
	private String deceased_babys_mrn;
	private String uae_residency_status;
	
	
}
