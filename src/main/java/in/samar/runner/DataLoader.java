package in.samar.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.samar.entity.PersonPlan;
import in.samar.repo.PersonPlanRepo;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private PersonPlanRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		repo.deleteAll();
		
		//Food
		PersonPlan p1=new PersonPlan();
		p1.setPersonName("samar");
		p1.setGender("male");
		p1.setPlanName("Food");
		p1.setPlanStatus("Approved");
		p1.setStartDate(LocalDate.now().minusWeeks(5));
		p1.setEndDate(LocalDate.now().plusYears(2).plusMonths(5));
		p1.setBenifitAmt(65830.86);
		
		PersonPlan p2=new PersonPlan();
		p2.setPersonName("samanwai");
		p2.setGender("male");
		p2.setPlanName("Food");
		p2.setPlanStatus("Denied");
		p2.setDeniedReason("No Intrest");
		
		
		PersonPlan p3=new PersonPlan();
		p3.setPersonName("vaishu");
		p3.setGender("Female");
		p3.setPlanName("Food");
		p3.setPlanStatus("Terminate");
		p3.setStartDate(LocalDate.now().minusWeeks(1));
		p3.setEndDate(LocalDate.now().plusYears(2));
		p3.setBenifitAmt(6000.50);
		p3.setTerminatedDate(LocalDate.now().plusDays(1));
		p3.setTerminatedReason("Employeed");
		
		//Cash
		PersonPlan p4=new PersonPlan();
		p4.setPersonName("Babbul");
		p4.setGender("male");
		p4.setPlanName("Cash");
		p4.setPlanStatus("Approved");
		p4.setStartDate(LocalDate.now().minusMonths(8));
		p4.setEndDate(LocalDate.now().plusYears(3).plusMonths(6));
		p4.setBenifitAmt(15296.23);
		
		PersonPlan p5=new PersonPlan();
		p5.setPersonName("manu");
		p5.setGender("Female");
		p5.setPlanName("Cah");
		p5.setPlanStatus("Denied");
		p5.setDeniedReason("No Info");
		
		
		PersonPlan p6=new PersonPlan();
		p6.setPersonName("Mintu");
		p6.setGender("male");
		p6.setPlanName("cash");
		p6.setPlanStatus("Terminate");
		p6.setStartDate(LocalDate.now().minusWeeks(1));
		p6.setEndDate(LocalDate.now().plusYears(1).plusMonths(2));
		p6.setBenifitAmt(9583.02);
		p6.setTerminatedDate(LocalDate.now());
		p6.setTerminatedReason("Un-Employeed");
		
		
		//Medical
		PersonPlan p7=new PersonPlan();
		p7.setPersonName("Chinnu");
		p7.setGender("male");
		p7.setPlanName("Medical");
		p7.setPlanStatus("Approved");
		p7.setStartDate(LocalDate.now());
		p7.setEndDate(LocalDate.now().plusYears(2));
		p7.setBenifitAmt(80528.00);
		
		PersonPlan p8=new PersonPlan();
		p8.setPersonName("sony");
		p8.setGender("Female");
		p8.setPlanName("Medical");
		p8.setPlanStatus("Denied");
		p8.setDeniedReason("Govt job");
		
		
		PersonPlan p9=new PersonPlan();
		p9.setPersonName("Sravs");
		p9.setGender("Female");
		p9.setPlanName("Medical");
		p9.setPlanStatus("Terminate");
		p9.setStartDate(LocalDate.now().minusWeeks(5));
		p9.setEndDate(LocalDate.now().plusYears(3));
		p9.setBenifitAmt(7514.50);
		p9.setTerminatedDate(LocalDate.now().plusDays(1));
		p9.setTerminatedReason("Un-Employeed");
		
		
		//Employement
		PersonPlan p10=new PersonPlan();
		p10.setPersonName("sahaja");
		p10.setGender("Female");
		p10.setPlanName("Employement");
		p10.setPlanStatus("Approved");
		p10.setStartDate(LocalDate.now().minusMonths(4));
		p10.setEndDate(LocalDate.now().plusYears(6).plusMonths(4));
		p10.setBenifitAmt(5447.45);
		
		PersonPlan p11=new PersonPlan();
		p11.setPersonName("Babbu");
		p11.setGender("male");
		p11.setPlanName("Employement");
		p11.setPlanStatus("Denied");
		p11.setDeniedReason("No-Education");
		
		
		PersonPlan p12=new PersonPlan();
		p12.setPersonName("Ashok");
		p12.setGender("male");
		p12.setPlanName("Employement");
		p12.setPlanStatus("Terminate");
		p12.setStartDate(LocalDate.now().minusYears(3));
		p12.setEndDate(LocalDate.now().plusYears(2));
		p12.setBenifitAmt(6000.50);
		p12.setTerminatedDate(LocalDate.now());
		p12.setTerminatedReason("Employeed");
		
		
		List<PersonPlan> list = Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12);
		
		repo.saveAll(list);
		
		
	}

}
