package com.mtml.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtml.entities.Game;
import com.mtml.entities.Player;
import com.mtml.util.SessionFactoryRegistry;

public class MTMLTest {
	public static void main(String[] args) {

		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		List<Player> players = null;
		Player player = null;
		Game game = null;
		
		try {
			sessionFactory = SessionFactoryRegistry.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			players = new ArrayList<Player>();
			
			player = new Player();
			player.setPlayerName("Sachin");
			player.setAge(35);
			player.setGender("Male");
			session.save(player);
			players.add(player);
			
			player = new Player();
			player.setPlayerName("Kohli");
			player.setAge(28);
			player.setGender("Male");
			session.save(player);
			players.add(player);

			game = new Game();
			game.setName("One Day Cricket");
			game.setType("Outdoor");
			game.setConductedDate(new Date());
			game.setPlayers(players);
			session.save(game);
			
			
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			SessionFactoryRegistry.closeSessionFactory();
		}
	}
}
