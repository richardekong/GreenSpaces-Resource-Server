package com.daveace.greenspaces.park;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkRepo extends JpaRepository<Park, String> {
}
