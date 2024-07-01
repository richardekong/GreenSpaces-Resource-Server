package com.daveace.greenspaces.address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,String> {
}
