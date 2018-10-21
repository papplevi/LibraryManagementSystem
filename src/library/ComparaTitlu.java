package library;
import java.util.Comparator;

public class ComparaTitlu implements Comparator<Carte> {

	@Override
	public int compare(Carte c1, Carte c2) {
		if (c1.getTitlu().compareTo(c2.getTitlu()) > 1)
		{
			return 1;
		}
		else if (c1.getTitlu().compareTo(c2.getTitlu()) < 1)
		{
			return -1;
		}
		else
		{
		return 0;
		}
	}

}
