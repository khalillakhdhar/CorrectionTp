package com.th.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.th.entities.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
