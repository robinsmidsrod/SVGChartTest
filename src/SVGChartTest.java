import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

import no.smidsrod.robin.svg.library.Item;
import no.smidsrod.robin.svg.library.SVGRenderer;
import no.smidsrod.robin.svg.library.SectorChart;
import no.smidsrod.robin.svg.library.Value;

public class SVGChartTest {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// Create new sector chart
		SectorChart chart = new SectorChart("My cool chart", "With an even cooler description");
		
		List<Item> items = chart.getItemList();
		
		Random random = new Random();
		// Put in some items we can use
		for (int i=1; i < 10; i++) {
			Item person = new Item("Person " + i);
			items.add(person);
			Value value = new Value(chart);
			value.set(0, random.nextDouble());
			person.getValueList().add(value);
		}
		
		// Output indented SVG to standard output
		SVGRenderer r = chart.getSVGRenderer();
		r.setPrettyPrint(true);
		r.renderSVG(System.out);
		
		// Output compact SVG to file
		r.setPrettyPrint(true);
		r.storeSVG(new File("C:\\Temp\\test.svg"));
		
		for(Item i: items) {
			System.err.println(i.getColor().toString());
		}
	}

}
