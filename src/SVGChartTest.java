import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

import no.smidsrod.robin.svg.library.BarChart;
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
		createSectorChart();
		createBarChart();
	}

	private static void createSectorChart() throws FileNotFoundException {
		// Create new sector chart
		SectorChart chart = new SectorChart("My cool sector chart", "With an even cooler description");
		
		chart.getRange(0).setUnit("percentage");
		
		// Fetch an empty list of Items
		List<Item> items = chart.getItemList();
		
		// We need some random numbers...
		Random random = new Random();
		
		// Put some Items into the list
		for (int i=1; i <= 10; i++) {
			Item item = new Item("Person " + i);
			if ( i % 2 == 0) {
				item.setHighlighted(true);
			}
			items.add(item);
			
			Value value = new Value(chart.getDimensionCount());
			value.set(chart.getRange(0).getDimension(), random.nextDouble() * 10);
			
			item.getValueList().add(value);
		}
		
		// Output indented SVG to file
		SVGRenderer r = chart.getSVGRenderer();
		r.setPrettyPrint(true);
		r.storeSVGDocument(new File("C:\\Temp\\sector_chart.svg"));
	}

	private static void createBarChart() throws FileNotFoundException {
		// Create new sector chart
		BarChart chart = new BarChart("My cool bar chart", "With an even cooler description");
		
		chart.getRange(0).setUnit("km");
		
		// Fetch an empty list of Items
		List<Item> items = chart.getItemList();
		
		// We need some random numbers...
		Random random = new Random();
		
		// Put some Items into the list
		for (int i=1; i <= 5; i++) {
			Item item = new Item("Person " + i);
			if ( i % 2 == 0) {
				item.setHighlighted(true);
			}
			items.add(item);
			
			Value value = new Value(chart.getDimensionCount());
			value.set(chart.getRange(0).getDimension(), random.nextDouble() * 10);
			
			item.getValueList().add(value);
		}
		
		// Output indented SVG to file
		SVGRenderer r = chart.getSVGRenderer();
		r.setPrettyPrint(true);
		r.storeSVGDocument(new File("C:\\Temp\\bar_chart.svg"));
	}

}
