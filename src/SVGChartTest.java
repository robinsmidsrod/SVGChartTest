import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;

import no.smidsrod.robin.svg.library.BarChart;
import no.smidsrod.robin.svg.library.Chart;
import no.smidsrod.robin.svg.library.Item;
import no.smidsrod.robin.svg.library.LineChart;
import no.smidsrod.robin.svg.library.ScatterChart;
import no.smidsrod.robin.svg.library.SectorChart;
import no.smidsrod.robin.svg.library.Value;
import no.smidsrod.robin.svg.library.renderer.SVGRenderer;

public class SVGChartTest {

	private static Random random = new Random();

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		createSectorChart("C:\\Temp\\sector_chart.svg");
		createEmailChart("C:\\Temp\\epost-aktivitet.svg");
		createBarChart("C:\\Temp\\bar_chart.svg");
		createLineChart("C:\\Temp\\line_chart.svg");
		createScatterChart("C:\\Temp\\scatter_chart.svg");
	}

	private static void createSectorChart(String filename)
			throws FileNotFoundException {
		// Create new sector chart
		SectorChart chart = new SectorChart("Employee salaries",
				"An overview of salaries for our employees");

		chart.getRange(0).setUnit("kr");
		chart.getRange(0).setName("Salary");

		// Fetch an empty list of Items
		List<Item> items = chart.getItemList();

		// Put some Items into the list
		for (int i = 1; i <= 30; i++) {
			Item item = new Item("Employee " + i);
			if (i % 2 == 0) {
				item.setHighlighted(true);
			}
			items.add(item);

			Value value = new Value(chart.getDimensionCount());
			value.set(0, random.nextDouble() * 300000 + 200000); // Salary
			item.getValueList().add(value);
		}

		renderChartToFile(chart, filename);
	}

	private static void createEmailChart(String filename)
			throws FileNotFoundException {
		// Create new sector chart
		BarChart chart = new BarChart("Aktivitet på SVG WG+IG epostliste",
				"Aktivitet for SVG WG medlemmer på SVG WG+IG epostliste siden 2008");

		chart.getRange(0).setUnit("stk");
		chart.getRange(0).setName("meldinger");

		// Fetch an empty list of Items
		List<Item> items = chart.getItemList();

		String[] companies = {
				"W3C",
				"Opera",
				"Canon",
				"Institut Telecom",
				"Ikivo",
				"Mozilla",
				"Apple",
				"Quickoffice",
				"Adobe",
				"Microsoft",
				"Samsung",
				"Telecom Italia SpA",
				"Rochester Institute of Technology",
				"PTC-Arbortext",
				"Ericsson",
				"Cisco",
		};
		double[] messages = {
				1089,
				253,
				158,
				42,
				22,
				19,
				19,
				18,
				11,
				3,
				1,
				0,
				0,
				0,
				0,
				0,
		};
		for(int i=0; i < companies.length; i++) {
			Item item = new Item(companies[i]);
			if ( i == 1 || i == 6 ) {
				item.setHighlighted(true);
			}
			items.add(item);
			Value value = new Value(chart.getDimensionCount());
			value.set(0, messages[i]);
			item.getValueList().add(value);
		}

		renderChartToFile(chart, filename);
	}

	private static void createBarChart(String filename)
			throws FileNotFoundException {
		// Create new sector chart
		BarChart chart = new BarChart("Employee age distribution",
				"An overview of our employee's age");

		chart.getRange(0).setUnit("year");
		chart.getRange(0).setName("Age");
		chart.getRange(0).setGridlineCount(9);
		chart.getRange(0).setMax(75);

		// Fetch an empty list of Items
		List<Item> items = chart.getItemList();

		// Put some Items into the list
		for (int i = 1; i <= 20; i++) {
			Item item = new Item("Employee " + i);
			if (i % 3 == 0) {
				item.setHighlighted(true);
			}
			items.add(item);

			Value value = new Value(chart.getDimensionCount());
			value.set(0, random.nextDouble() * 50 + 20); // Age
			item.getValueList().add(value);
		}

		renderChartToFile(chart, filename);
	}

	private static void createLineChart(String filename)
			throws FileNotFoundException {
		// Create new sector chart
		LineChart chart = new LineChart("Car type age/milage",
				"An overview over different cars and their respective ages and milages");

		chart.getRange(0).setUnit("km");
		chart.getRange(0).setName("Milage");
		chart.getRange(0).setGridlineCount(10);

		chart.getRange(1).setUnit("year");
		chart.getRange(1).setName("Age");
		chart.getRange(1).setGridlineCount(2);
		chart.getRange(1).setMin(5);
		chart.getRange(1).setMax(35);

		// Fetch an empty list of Items
		List<Item> items = chart.getItemList();

		// Put some Items into the list
		for (int i = 1; i <= 5; i++) {
			Item item = new Item("Car " + i);
			if (i % 2 == 0) {
				item.setHighlighted(true);
			}
			items.add(item);

			for (int j = 1; j <= 3; j++) {
				Value value = new Value(chart.getDimensionCount());
				value.set(0, random.nextDouble() * j * 200000); // Milage
				value.set(1, j * 10); // Age
				item.getValueList().add(value);
			}
		}

		renderChartToFile(chart, filename);
	}

	private static void createScatterChart(String filename)
			throws FileNotFoundException {
		// Create new sector chart
		ScatterChart chart = new ScatterChart(
				"Income by age/experience",
				"An overview over people and their income across their life with different jobs");

		chart.getRange(0).setUnit("year");
		chart.getRange(0).setName("Age");
		chart.getRange(0).setGridlineCount(4);
		chart.getRange(0).setMin(20);
		chart.getRange(0).setMax(60);

		chart.getRange(1).setUnit("year");
		chart.getRange(1).setName("Experience");
		chart.getRange(1).setGridlineCount(7);
		chart.getRange(1).setMax(8);

		chart.getRange(2).setUnit("kr");
		chart.getRange(2).setName("Salary");
		// chart.getRange(0).setGridlineCount(10);

		// Fetch an empty list of Items
		List<Item> items = chart.getItemList();

		// Put some Items into the list
		for (int i = 1; i <= 10; i++) {
			Item item = new Item("Person " + i);
			if (i % 2 == 0) {
				item.setHighlighted(true);
			}
			items.add(item);

			for (int j = 1; j <= 3; j++) {
				Value value = new Value(chart.getDimensionCount());
				value.set(0, j * 10 + 20); // Age
				value.set(1, j + random.nextDouble() * 5); // Experience
				value.set(2, random.nextDouble() * j * 150000); // Salary
				item.getValueList().add(value);
			}
		}

		renderChartToFile(chart, filename);
	}

	private static void renderChartToFile(Chart chart, String filename)
			throws FileNotFoundException {
		// Output indented SVG to file
		SVGRenderer r = chart.getSVGRenderer();
		r.setPrettyPrint(true);
		r.storeSVGDocument(new File(filename));
		// Output to screen
		// System.out.print(r.getSVGDocument());
	}
}
