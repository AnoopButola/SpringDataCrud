package com.example.accessingdatamysql;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DeploymentJob {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String jobName;
	
	private String packageName;

	private transient  String  jobDescription;
	
	
	
	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}

	/**
	 * @param jobDescription the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = "deployement_job";
	}

	private transient  Set<Server> serversToUpgrade;

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
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * @return the serversToUpgrade
	 */
	public Set<Server> getServersToUpgrade() {
		return serversToUpgrade;
	}

	/**
	 * @param serversToUpgrade the serversToUpgrade to set
	 */
	public void setServersToUpgrade(Set<Server> serversToUpgrade) {
		this.serversToUpgrade = serversToUpgrade;
	}


	
	
	
	
	
	
}
