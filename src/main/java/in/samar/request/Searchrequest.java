package in.samar.request;

import java.time.LocalDate;

import lombok.Data;


@Data
public class Searchrequest {

	
	private String planName;
	private String planStatus;
	private String gender;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
}
