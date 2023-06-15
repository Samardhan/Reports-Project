package in.samar.request;

import lombok.Data;

@Data
public class Searchrequest {

	private String planName;
	private String planStatus;
	private String gender;
	private String startDate;
	private String endDate;

}
