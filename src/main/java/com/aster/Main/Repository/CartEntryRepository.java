package com.aster.Main.Repository;

import com.aster.Main.Entity.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartEntryRepository extends JpaRepository<CartEntry,Integer> {
}
