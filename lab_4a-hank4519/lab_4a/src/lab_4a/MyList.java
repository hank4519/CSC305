package lab_4a;

import java.util.Optional;
import java.util.LinkedList;
import java.util.List;

public class MyList<E> implements Multiset<E>{
	
	private List<E> list = new LinkedList<E>();

	@Override
	public void add(E element) {
		list.add(element); 
		
	}

	@Override
	public boolean remove(E element) {
		boolean flag = false; 
		for(int i = 0; i < list.size(); i++ ) { 
			if (list.get(i).equals(element)) { 
				list.remove(i); 
				flag = true; 
			}
		}
		return flag; 
	}

	@Override
	public int size() {
		return list.size(); 
	}

	@Override
	public int count(E element) {
		int count = 0; 
		for (E e: list) { 
			if (e.equals(element))
				count++; 
		}
		return count; 
	}

	@Override
	public Optional<E> grab() {
		// TODO Auto-generated method stub
		if (size() <= 0) { 
			return Optional.empty(); 
		}else { 
			return Optional.of(list.remove(0)); 
		}
	} 
	

}
