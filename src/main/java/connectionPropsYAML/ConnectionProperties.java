package connectionPropsYAML;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.util.Arrays;

public class ConnectionProperties {

	public static void main(String[] args) {
		try {

			// Load the MySQL JDBC driver

			String driverName = "com.mysql.cj.jdbc.Driver";

			Class.forName(driverName);

			// Get the Driver instance

			String serverName = "localhost";

			String schema = "test";

			String url = "jdbc:mysql://" + serverName + "/" + schema;

			Driver driver = DriverManager.getDriver(url);

			// Get available properties

			DriverPropertyInfo[] properties = driver.getPropertyInfo(url, null);

			for (int i = 0; i < properties.length; i++) {

				// Property information

				String name = properties[i].name;

				boolean required = properties[i].required;

				String value = properties[i].value;

				String description = properties[i].description;

				String[] choices = properties[i].choices;

				System.out.println("Property : " + name + "\nRequired : " + required + "\nValue : " + value
						+ "\nDescription : " + description + "\nChoices : "
						+ (choices != null ? Arrays.asList(choices) : null) + "\n");

			}
		} catch (ClassNotFoundException e) {

			System.out.println("Could not find the database driver " + e.getMessage());
		} catch (SQLException e) {

			System.out.println("Could not retrieve database metadata " + e.getMessage());
		}

	}

}
