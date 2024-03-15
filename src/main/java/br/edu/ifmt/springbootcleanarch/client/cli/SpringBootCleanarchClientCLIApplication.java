package br.edu.ifmt.springbootcleanarch.client.cli;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.annotation.EnableCommand;

@SpringBootApplication
@EnableCommand(MyCommands.class)
public class SpringBootCleanarchClientCLIApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCleanarchClientCLIApplication.class, args);
	}
	
	@Bean
	UserPort userPort() {
		return new UserPort() {

			@Override
			public String createUser(String username, String email, String password) throws IOException {

				URL url = new URL("http://localhost:7070/users");
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setRequestProperty("Content-Type", "application/json");
				//Map<String, String> parameters = new HashMap<>();
				//parameters.put("username", username);
				//parameters.put("email", email);
				//parameters.put("password", password);
				String parameters = String.format("""
						{
							"username":"%s",
							"email":"%s",
							"password":"%s"
						}
						""",username, email,password);

				con.setDoOutput(true);
				con.setConnectTimeout(5000);
				con.setReadTimeout(5000);				
				DataOutputStream out = new DataOutputStream(con.getOutputStream());
				//out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
				out.writeBytes(parameters);
				out.flush();
				out.close();

				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();
				con.disconnect();
				return content.toString();			
				
				// WebClient client = WebClient.builder()
                // .baseUrl("http://localhost:8080/users")
                // .defaultHeader("Accept","application/json")
                // .build();

				// HttpServiceProxyFactory factory = HttpServiceProxyFactory
				// .builder(WebClientAdapter.forClient(client))
				// .build();
        		
				// return "";//factory.createClient(UserPort.class);				
			}

		};
	}
}
