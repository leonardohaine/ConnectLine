package br.com.jlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jlab.dao.HospitalDAO;
import br.com.jlab.model.Hospital;

@Service("HospitalService")
@Transactional(readOnly = true)
public class HospitalService {

	@Autowired
	HospitalDAO hospitalDAO;

	@Transactional(readOnly = false)
	public void saveHospital(Hospital hospital) {
		getHospitalDAO().saveHospital(hospital);
	}

	@Transactional(readOnly = false)
	public void deleteHospital(Hospital hospital) {
		getHospitalDAO().deleteHospital(hospital);
	}

	@Transactional(readOnly = false)
	public void updateHospital(Hospital hospital) {
		getHospitalDAO().updateHospital(hospital);
	}

	public Hospital getHospitalById(Long id) {
		return getHospitalDAO().getHospitalById(id);
	}

	/**
	 * @return the hospitalDAO
	 */
	public HospitalDAO getHospitalDAO() {
		return hospitalDAO;
	}

	/**
	 * @param safx04DAO
	 *            the hospitalDAO to set
	 */
	public void setHospitalDAO(HospitalDAO hospitalDAO) {
		this.hospitalDAO = hospitalDAO;
	}

	public List<Hospital> getHospital() {
		return getHospitalDAO().getHospital();
	}

}
