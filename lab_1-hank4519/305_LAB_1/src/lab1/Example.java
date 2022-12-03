package lab1;

class Example {
	
  private String name;
  private int[] nums;
  
  public Example(String name, int [] nums) { 
	  this.name = name; 
	  this.nums = nums; 
  }

  boolean sameName(String other)
  {
    return name.equals(other);
  }

  public int[] getNums()
  {
    return nums;
  }
  
  public void setNums(int [] nums) { 
	  this.nums = nums; 
  }
}  