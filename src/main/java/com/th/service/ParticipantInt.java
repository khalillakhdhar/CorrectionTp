package com.th.service;

import java.util.List;

import com.th.entities.Participant;

public interface ParticipantInt {
	public void assignParticipant(long ids,Participant participant);
	public void deleteOne(long id);
	public List<Participant> showAll();
	
}
