package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {
	private final List<Integer> listValues;

	public LogicsImpl(final int size) {
		//TODO Auto-generated constructor stub

		this.listValues = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			this.listValues.add(i, 0);
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.listValues.size();
	}

	@Override
	public List<Integer> values() {
		// TODO Auto-generated method stub
		/*List<Integer> returnList = new LinkedList<>();

		for(int i = 0; i <= this.size; i++) {
			returnList.add(i);
		}*/
		return List.copyOf(this.listValues); //ricorda CopyOf per returnare le cose che hai dentro la classe
	}

	@Override
	public List<Boolean> enablings() {
		// TODO Auto-generated method stub
		List<Integer> returnList = new ArrayList<>(this.listValues);
		/*for (int i = 0; i < this.listValues.size(); i++) {
			if(this.listValues.get(i).equals(this.size)) {
				returnList.set(i, false);
			} else {
				returnList.set(i, true);
			}
		}*/

		return returnList.stream()
				.map(x -> x < this.listValues.size()) // !x.equals(this.listValues.size()))
				.toList();
	}

	@Override
	public int hit(int elem) {
		// TODO Auto-generated method stub
		final var result = this.listValues.get(elem) + 1;
		this.listValues.set(elem, result);
		return result;
	}

	@Override
	public String result() {
		return this.listValues.stream()
			.map(x -> x.toString())
			.collect(Collectors.joining("|", "<<", ">>"));
		// TODO Auto-generated method stub
		/*StringBuilder print = new StringBuilder("<<");
		for (Integer integer : listValues) {
			print.append(integer);
			print.append("|");
		}
		print.deleteCharAt(print.lastIndexOf("|"));
		print.append(">>");
		return print.toString();*/

	}

	@Override
	public boolean toQuit() {
		return this.listValues.stream()
			.allMatch(x -> x.equals(this.listValues.get(0)) && !x.equals(0));
		// TODO Auto-generated method stub
		/*List<Integer> copy = new ArrayList<>(this.listValues);

		long quit = copy.stream()
				.filter(x -> !x.equals(0))
				.filter(x -> x.equals(this.listValues.get(0)))
				.count();
		if((int) quit == this.size) {
			return true;
		} else {
			return false;
		}*/
	}
}
