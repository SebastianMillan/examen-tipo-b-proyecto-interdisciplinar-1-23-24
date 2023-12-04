package com.salesianostriana.dam.rest.ticket.repo;

import com.salesianostriana.dam.rest.ticket.GetTicketDto;
import com.salesianostriana.dam.rest.ticket.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("select t from Ticket t")
    Page<Ticket> listarTicketConPage(Pageable pageable);

    @Query("select t from Ticket t where t.id=?1")
    Optional<Ticket> encontrarTicketPorId(Long id);

    @Query("""
            select new com.salesianostriana.dam.rest.ticket.GetTicketDto(
                t.id, t.title, t.deadline
            )
            from Ticket t
            """)
    Page<GetTicketDto> listarTicketDto(Pageable pageable);
}
