package fi.rbmk.ticketguru.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Table(name = "Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_ID")
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "eventTicket_ID")
    private EventTickets eventTickets;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "ticketStatus_ID")
    private TicketStatus ticketStatus;

    @NotEmpty(message = "Ticket checksum is required")
    @Length(max = 20)
    @Column(name = "ticketCheckSum")
    private String checkSum;

    @OneToOne(mappedBy = "ticket")
    private SaleRow saleRow;

    public Ticket() {
    }

    public Ticket(Ticket ticket) {
    }

    public Ticket(EventTickets eventTickets, TicketStatus ticketStatus, String checkSum) {
        this.eventTickets = eventTickets;
        this.ticketStatus = ticketStatus;
        this.checkSum = checkSum;
    }

    // Getters
    public Long getId() {
        return this.id;
    }

    public EventTickets getEventTicket() {
        return this.eventTickets;
    }

    public TicketStatus getTicketStatus() {
        return this.ticketStatus;
    }

    public String getCheckSum() {
        return this.checkSum;
    }

    public SaleRow getSaleRow() {
        return saleRow;
    }

    // Setters
    public void setEventTicket(EventTickets eventTickets) {
        this.eventTickets = eventTickets;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public void setTicketCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }
}