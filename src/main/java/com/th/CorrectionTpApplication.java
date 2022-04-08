package com.th;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.th.entities.Admin;
import com.th.entities.Participant;
import com.th.entities.Role;
import com.th.entities.Sortie;
import com.th.repository.ParticipantRepository;
import com.th.service.AccountServiceImpl;
import com.th.service.ParticipantService;
import com.th.service.SortieService;

@SpringBootApplication
public class CorrectionTpApplication implements CommandLineRunner {
	@Autowired
	AccountServiceImpl api;
	@Autowired 
	SortieService sortieService;
	@Autowired 
	ParticipantService participantService;
	private String ip;
	
	public static void main(String[] args) {
		SpringApplication.run(CorrectionTpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		 InetAddress ip;
	        String hostname;
	        try {
	            ip = InetAddress.getLocalHost();
	            hostname = ip.getHostName();
	            System.out.println("Your current IP address : " + ip);
	            System.out.println("Your current Hostname : " + hostname);
	 
	        } catch (UnknownHostException e) {
	 
	            e.printStackTrace();
	        }
		api.saveUser(new Admin("test@gmail.com", "teste", "teste", 1,"aucune","20788999", null));
		api.saveUser(new Admin("test2@gmail.com", "teste2", "teste2", 1,"aucune2","20788933", null));
		Role r1=new Role();
		
		Sortie s1=sortieService.addOne(new Sortie("loisir", "01/5/2022", "03/05/2022", "aucune", null));
		
		sortieService.assignResponsable("teste",s1 );
		participantService.assignParticipant(s1.getId(), new Participant("khalil", "lakhdhar", "khalil@gmail.com", "20999888", 33, null));
		r1.setRoleName("organisateur");
		Role r2=new Role();
		r2.setRoleName("guide");
		api.saveRole(r1);
		api.saveRole(r2);
		api.addRoleToUser("test@gmail.com", "organisateur");
		api.addRoleToUser("test2@gmail.com", "guide");

		
		
		
	}

}
