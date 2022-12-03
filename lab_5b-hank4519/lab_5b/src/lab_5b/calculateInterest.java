package lab_5b;

public abstract class calculateInterest {
	
	/**
	   * principal denotes the loan taken in dollars
	   * annual_rate denotes the annual rate of interest in decimals (5%=0.05)
	   * N denotes the number of times interest is compounded yearly
	   * time denotes the time in years for which interest is calculated
	   */
	double principal; 
    double annual_rate; 
	static final int N = 12; 
	int time; 
	
	public calculateInterest(double principal, double annual_rate, int time) { 
		this.principal = principal; 
		this.annual_rate = annual_rate; 
		this.time = time; 
	}
	public abstract double accept(InterestVisitor obj);
}