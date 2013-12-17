package fr.lutarony.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lutarony.model.Wrestler;

@Service("wrestlerService")
@Transactional
public class WrestlerServiceImpl implements WrestlerService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addWrestler(Wrestler wrestler) {
		sessionFactory.getCurrentSession().save(wrestler);
	}

	@Override
	public List<Wrestler> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Wrestler").list();
	}

}
