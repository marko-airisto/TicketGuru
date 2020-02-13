package fi.rbmk.ticketguru.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ticket_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EventTicket_ID")
    private EventTicket eventTicket;

    @ManyToOne
    @JoinColumn(name = "TicketStatus_ID")
    private TicketStatus ticketStatus;

    @NotEmpty(message = "Ticket checksum is required")
    @Length(max = 20)
    @Column(name = "TicketCheckSum")
    private String checkSum;

    public Ticket() {}
    
    public Ticket(Ticket ticket) {}

    public Ticket(EventTicket eventTicket, TicketStatus ticketStatus, String checkSum) {
        this.eventTicket = eventTicket;
        this.ticketStatus = ticketStatus;
        this.checkSum = checkSum;
    }

    //Getters
    public Long getId() {
        return this.id;
    }
    public EventTicket getEventTicket() {
        return this.eventTicket;
    }
    public TicketStatus getTicketStatus() {
        return this.ticketStatus;
    }
    public String getCheckSum() {
        return this.checkSum;
    }
    //Setters
    public void setEventTicket(EventTicket eventTicket) {
        this.eventTicket = eventTicket;
    }
    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
    public void setTicketCheckSum(String checkSum) {
        this.checkSum = checkSum;
    }
}