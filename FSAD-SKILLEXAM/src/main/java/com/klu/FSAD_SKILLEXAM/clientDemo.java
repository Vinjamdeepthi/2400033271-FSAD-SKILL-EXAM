package com.klu.FSAD_SKILLEXAM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class clientDemo 
{
 public static void main(String[] args) 
 {
  Configuration cfg = new Configuration();
  cfg.configure();
  cfg.addAnnotatedClass(Restaurant.class);

  SessionFactory sf = cfg.buildSessionFactory();
  Session session = sf.openSession();

  Transaction tx = session.beginTransaction();

  // INSERT RECORD
  Restaurant r = new Restaurant(33271,"deepthi","10-3-2026","open");
  session.persist(r);

  System.out.println("Record Inserted");

  tx.commit();

  // UPDATE USING HQL
  session.beginTransaction();

  String hql = "update Restaurant set name=:n , status=:s where id=:i";

  Query q = session.createQuery(hql);

  q.setParameter("n","deepthi");
  q.setParameter("s","present");
  q.setParameter("i",33271);

  int result = q.executeUpdate();

  System.out.println("Records Updated = "+result);

  session.getTransaction().commit();

  session.close();
  sf.close();
 }
}