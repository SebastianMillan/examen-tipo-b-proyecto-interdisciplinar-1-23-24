package com.salesianostriana.dam.rest.ticket.controller;

import com.salesianostriana.dam.rest.ticket.GetTicketDto;
import com.salesianostriana.dam.rest.ticket.exception.TicketListEmptyException;
import com.salesianostriana.dam.rest.ticket.exception.TicketNotFoundException;
import com.salesianostriana.dam.rest.ticket.model.Ticket;
import com.salesianostriana.dam.rest.ticket.repo.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketRepository ticketRepository;

    @GetMapping("/")
    public Page<Ticket> getAll(@PageableDefault(page = 0, size = 5)Pageable pageable) {
        Page<Ticket> result = ticketRepository.listarTicketConPage(pageable);
        if (result.isEmpty()) {
            throw new TicketListEmptyException();
        }
        return result;

    }


    @GetMapping("/{id}")
    public Ticket getById(@PathVariable Long id) {
        Optional<Ticket> result = ticketRepository.encontrarTicketPorId(id);
        if (result.isEmpty()) {
            throw new TicketNotFoundException(id);
        }
        return result.get();

    }

    @GetMapping("/dto")
    public Page<GetTicketDto> getAllDto(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        return ticketRepository.listarTicketDto(pageable);
    }


}
