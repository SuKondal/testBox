package helpers;

import net.masterthought.cucumber.ReportBuilder;
import org.apache.velocity.exception.VelocityException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CucumberReports {

	
	public static void generateReport() throws VelocityException, IOException {
		File reportOutputDirectory = new File("target/resmed-cucumber-report");
		List list = new ArrayList();
		list.add("target/cucumber-json-report.json");

		String pluginUrlPath = "";
		String buildNumber = "1";
		String buildProject = "ResmedTestBox";
		boolean skippedFails = true;
		boolean pendingFails = true;
		boolean undefinedFails = true;
		boolean missingFails = true;
		boolean flashCharts = true;
		boolean runWithJenkins = false;
		boolean highCharts = false;

		ReportBuilder reportBuilder = new ReportBuilder(list, reportOutputDirectory, pluginUrlPath, buildNumber,
				buildProject, skippedFails, pendingFails, undefinedFails, missingFails, flashCharts, runWithJenkins,
				highCharts, false);
		reportBuilder.generateReports();
	}
}
