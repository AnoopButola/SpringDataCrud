package com.example.accessingdatamysql;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Anoop
 *
 */
@Entity
public class DeploymentJobServer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	

	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "server_id", referencedColumnName = "id")
	  private Server server;
	  
	  
	  @OneToOne(cascade = CascadeType.ALL)
	  @JoinColumn(name = "job_id", referencedColumnName = "id")
	  private DeploymentJob job;
	  
	  
	  
	  
	  
	  /**
	 * @return the job
	 */
	public DeploymentJob getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(DeploymentJob job) {
		this.job = job;
	}

	private String status;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}

	/**
	 * @param server the server to set
	 */
	public void setServer(Server server) {
		this.server = server;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	  
	  
	
}
