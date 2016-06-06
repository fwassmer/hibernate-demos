/* 
 * Hibernate, Relational Persistence for Idiomatic Java
 * 
 * JBoss, Home of Professional Open Source
 * Copyright 2013 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package org.hibernate.osgitest;

import org.hibernate.osgitest.entity.DataPoint;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Brett Meyer
 */
public class DataPointServiceImpl implements DataPointService {

	@PersistenceContext(unitName="managed-jpa")
	private EntityManager entityManager;

	@Transactional(Transactional.TxType.REQUIRED)
	public void add(DataPoint dp) {
		entityManager.persist( dp );
		entityManager.flush();
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public List<DataPoint> getAll() {
		return entityManager.createQuery( "select d from DataPoint d", DataPoint.class ).getResultList();
	}

	@Transactional(Transactional.TxType.REQUIRED)
	public void deleteAll() {
		entityManager.createQuery( "delete from DataPoint" ).executeUpdate();
		entityManager.flush();
	}

}
