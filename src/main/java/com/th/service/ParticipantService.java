package com.th.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.th.entities.Participant;
import com.th.entities.Sortie;
import com.th.repository.ParticipantRepository;
import com.th.repository.SortieRepository;

@Service
public class ParticipantService implements ParticipantInt {
@Autowired
ParticipantRepository participantRepository;
@Autowired
SortieRepository sortieRepository;

public void assignParticipant(long ids,Participant participant)
{
Sortie sortie=sortieRepository.findById(ids).orElseThrow();
participant.setSortie(sortie);
participantRepository.save(participant);

}

@Override
public void deleteOne(long id) {
	// TODO Auto-generated method stub
	participantRepository.deleteById(id);
}

@Override
public List<Participant> showAll() {
	// TODO Auto-generated method stub
	return participantRepository.findAll();
}

}
