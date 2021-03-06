/*
 * A Collection of Miscellaneous Utilities
 *
 * Copyright 2010
 *      The President and Fellows of Harvard College.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. Neither the name of the University nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE UNIVERSITY AND CONTRIBUTORS ``AS IS'' AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED.  IN NO EVENT SHALL THE UNIVERSITY OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

package edu.harvard.util.job;

import java.util.*;


/**
 * The default, quiet job master
 * 
 * @author Peter Macko
 */
public class DefaultJobMaster implements JobMaster, JobObserver {
	
	private LinkedList<Job> jobs;

	
	/**
	 * Constructor of class DefaultJobMaster
	 */
	public DefaultJobMaster() {
		jobs = new LinkedList<Job>();
	}
	
	
	/**
	 * Run the jobs
	 * 
	 * @throws JobException if one of the jobs failed
	 * @throws JobCanceledException if one of the jobs was canceled
	 */
	public void run() throws JobException {

		for (Job j : jobs) {
			j.setJobObserver(this);
			j.run();
		}
	}

	
	/**
	 * Add a job
	 *
	 * @param job the job to add
	 */
	public void add(Job job) {
		jobs.add(job);
	}
	
	
	/**
	 * Set the range of progress values
	 *
	 * @param min the minimum value
	 * @param max the maximum value
	 */
	public void setRange(int min, int max) {
	}
	
	
	/**
	 * Set the progress value
	 *
	 * @param value the progress value
	 */
	public void setProgress(int value) {
	}
	
	
	/**
	 * Set the progress as indeterminate
	 */
	public void makeIndeterminate() {
	}
}
