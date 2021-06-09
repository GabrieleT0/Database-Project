package ecommerce;
import java.sql.*;



public class EcommerceBD {
	public EcommerceBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
					} catch(ClassNotFoundException e) {
						System.err.print("Class not found: "+e.getMessage());
					}
	}
	
	private Connection getConnection() throws SQLException{
		String url="jdbc:mysql://localhost:3306/ecommerce?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		Connection connection= DriverManager.getConnection(url, "gabriele", "123456");
		System.out.print("Connessione OK! \n");
		
		return connection;
	}
	
	private void relaseConnection(Connection connection) throws SQLException{
		if(connection!=null) {
			connection.close();
			connection=null;
		}
	}
	
	public void update() {
		try {
			Connection con= this.getConnection();
			this.relaseConnection(con);
	}	catch(SQLException e) {
		System.err.print(e.getMessage());
	}
	}
	
	//OPERAZIONE 1
	public void insertProdotto() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("INSERT INTO Prodotto"+" VALUES('XXXXXX','Apple MacBook Pro 16, 16GB RAM, Archiviazione 512GB, Intel Core i7 2,6GHz Grigio Siderale','PC portatili','2359.99')");
			if (result==1) { 
				System.out.println("Prodotto inserito ");
				con.commit();
				
			}else System.out.println("Errore inserimento prodotto ");
		
		}catch(SQLException e) {
					System.err.println(e.getMessage());
				} finally { 
					try { 
						if(rs !=null) rs.close();
						if(st!=null) st.close();
						ConnectionPool.releaseConnection(con);
					} catch(SQLException e) {
						System.err.println(e.getMessage());
					}
				}
			}
	
	//OPERAZIONE 2
	public void insertAziendaC() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("INSERT INTO AziendaCostruttrice"+" VALUES('52')");
			if (result==1) {
				System.out.println("Azienda costruttrice inserita ");
				con.commit();
			}else System.out.println("Errore inserimento azienda costruttrice\n");
			
		}catch(SQLException e) {
					System.err.println(e.getMessage());
				} finally { 
					try { 
						if(rs !=null) rs.close();
						if(st!=null) st.close();
						ConnectionPool.releaseConnection(con);
					} catch(SQLException e) {
						System.err.println(e.getMessage());
					  }
				  }
	}
	
	//OPERZAIONE 3
	public void insertMagazzino() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("INSERT INTO Magazzino"+" VALUES('4')");
			if (result==1) {
				System.out.println("Magazzino inserito");
				con.commit();
			}else System.out.println("Errore inserimento magazzino\n");
		
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally { 
			try { 
				if(rs !=null) rs.close();
				if(st!=null) st.close();
				ConnectionPool.releaseConnection(con);
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			  }
		  }
}
		
	//OPERAZIONE 4
	public void insertPagamento() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("INSERT INTO Pagamento(IDpagamento,valuta,importo,dataPagamento,numeroOrdine) VALUES('10070','Euro','749.00','2019-10-16 10:45:49','78452554556214')");
			if (result==1) {
				System.out.println("Pagamento relativo ad un ordine inserito");
				con.commit();
			} else System.out.println("Errore inserimento pagamento\n");
		
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally { 
			try { 
				if(rs !=null) rs.close();
				if(st!=null) st.close();
				ConnectionPool.releaseConnection(con);
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			  }
		  }
	}
	
	//OPERAZIONE 5
	public void insertGestore() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("INSERT INTO Gestore(codiceFiscale,ragioneSociale,IDazienda) VALUES('ALNSSS89A78M425P','NULL','12')");
			if(result==1) {
				System.out.println("Gestore relativo ad una azienda inserito");
				con.commit();
			}else  System.out.println("Errore inserimento gestore");
		
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally { 
			try { 
				if(rs !=null) rs.close();
				if(st!=null) st.close();
				ConnectionPool.releaseConnection(con);
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			  }
		  }
	}
	
	//OPERAZIONE 6
	public void InsertPayPal() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("INSERT INTO PayPal(email,psw,IDpagamento) VALUES('danielet72@gmail.com','dany342','10002')");
			if(result==1) {
				System.out.println("Pagamento PayPal aggiunto");
				con.commit();
			} else System.out.println("Errore aggiunta PayPal");
	
		}
		catch(SQLException e) {
		System.err.println(e.getMessage());
	} finally { 
		try { 
			if(rs !=null) rs.close();
			if(st!=null) st.close();
			ConnectionPool.releaseConnection(con);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		  }
	  }
}

	//OPERAZIONE 7
	public void retrieveNumPr() {
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		try {
			con = ConnectionPool.getConnection();
	
			String sql=("SELECT COUNT(*) AS total FROM composto WHERE numeroOrdine=?");
			String param_numO="10245367452139";
			ps=con.prepareStatement(sql);
			ps.setString(1, param_numO);
			rs=ps.executeQuery();
			while(rs.next()) {
				int totale=rs.getInt("total");
				System.out.printf("Numero prodotti nell'ordine %s: %d \n",param_numO,totale);
			}
		
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally { 
			try { 
				if(rs !=null) rs.close();
				if(ps!=null) ps.close();
				ConnectionPool.releaseConnection(con);
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			  }
		  }
	}
	
	//OPERAZIONE 8
	public void insertOrdine() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("INSERT INTO Ordine(numeroOrdine,dataOrdine,importoOrdine,email,statoDiElaborazione) VALUES('12489786512305','2020-01-13 15:00:15','33.99','lucarossi@gmail.com','IN LAVORAZIONE')");
			if (result==1) {
				System.out.println("Ordine inserito"); 
				con.commit();
			}else System.out.println("Errore inserimento Ordine");
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally { 
			try { 
				if(rs !=null) rs.close();
				if(st!=null) st.close();
				ConnectionPool.releaseConnection(con);
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			  }
		  }
	}

	//OPERAZIONE 9
	public void updatePrezzo() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("UPDATE Prodotto SET prezzo=69.99 WHERE codice='MZ-V7S250BW'");
			if (result==1) {
				System.out.println("Prezzo aggiornato"); 
				con.commit();
				}else System.out.println("Errore aggiornamento prezzo");
	
		}catch(SQLException e) {
		System.err.println(e.getMessage());
	} finally { 
		try { 
			if(rs !=null) rs.close();
			if(st!=null) st.close();
			ConnectionPool.releaseConnection(con);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		  }
	  }
}

	//OPERAZIONE 10
	public void updateStatoOrdine() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("UPDATE ordine SET statoDiElaborazione='SPEDITO' WHERE numeroOrdine='45236987452125'");
			if (result==1) {
				System.out.println("Stato ordine aggiornato"); 
				con.commit();
			}else System.out.println("Errore aggiornamento stato");
		
		}catch(SQLException e) {
		System.err.println(e.getMessage());
	} finally { 
		try { 
			if(rs !=null) rs.close();
			if(st!=null) st.close();
			ConnectionPool.releaseConnection(con);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
		  }
	  }
	}
	
	//OPERAZIONE 11
	public void retrieveImporto() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			
			String q2=("SELECT importo FROM pagamento WHERE IDpagamento=?");
			String param_IDp="00018";
			PreparedStatement ps2=con.prepareStatement(q2);
			ps2.setString(1, param_IDp);
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next()) {
				String importo=rs2.getString(1);
				System.out.printf("%s \n",importo);
			}
			
		}catch(SQLException e) {
				System.err.println(e.getMessage());
			} finally { 
				try { 
					if(rs !=null) rs.close();
					if(st!=null) st.close();
					ConnectionPool.releaseConnection(con);
				} catch(SQLException e) {
					System.err.println(e.getMessage());
				  }
			  }
		}
	
	//OPERAZIONE 12
	public void insertProdottoOrd() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st = con.createStatement();
			int result=st.executeUpdate("INSERT INTO composto (quantità,codice,numeroOrdine) VALUES('1','4041K11','78542216984565')");
			if (result==1) {
				System.out.println("Prodotto inserito nell'ordine 78542216984565"); 
				con.commit();
			}else System.out.println("Errore inserimento prodotto nell'ordine");
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally { 
			try { 
				if(rs !=null) rs.close();
				if(st!=null) st.close();
				ConnectionPool.releaseConnection(con);
			} catch(SQLException e) {
				System.err.println(e.getMessage());
			  }
		  }
	}
	
	public void printTable(String tableName) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = ConnectionPool.getConnection();

			st = con.createStatement();

			rs = st.executeQuery("SELECT * FROM " + tableName);

			ResultSetMetaData md = rs.getMetaData();

			
			for (int i = 1; i <= md.getColumnCount(); i++)
				System.out.print(md.getColumnLabel(i) + " ");
			System.out.println();


			while (rs.next()) {
				for (int i = 1; i <= md.getColumnCount(); i++)
					System.out.print(rs.getString(i) + " ");
				System.out.println();
			}
		} catch (SQLException s) {
			System.err.println(s.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				ConnectionPool.releaseConnection(con);
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		}
	

	public void ricercaProdotto() {
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		
		try {
			con = ConnectionPool.getConnection();
			
			String sql="SELECT codice,nome FROM prodotto WHERE prezzo>?";
			String param_prodotto="40.00";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, param_prodotto);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String codice=rs.getString(1);
				String nome=rs.getString("nome");
				System.out.printf("%s %s \n",codice,nome);
			}
			
		}catch(SQLException e) {
		System.err.println(e.getMessage());
	} finally { 
		try { 
			if(rs !=null) rs.close();
			if(ps!=null) ps.close();
			ConnectionPool.releaseConnection(con);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			}	
		}	
	}
	
	public void ricercaCartaDiCredito() {
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			 
			String sql="SELECT numerocarta FROM cartadicredito WHERE intestatarioCarta=?";
			String param_carta="Andrea Verdi";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, param_carta);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String numeroCarta=rs.getString(1);
				System.out.printf("%s \n", numeroCarta);
			}
		
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally { 
			try { 
				if(rs !=null) rs.close();
				if(ps!=null) ps.close();
				ConnectionPool.releaseConnection(con);
			} catch(SQLException e) {
				System.err.println(e.getMessage());
				}	
			}	
		}
	
	public void ricercaCliente() {
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			
			String sql="SELECT nome,cognome FROM cliente WHERE città=?";
			String param_cliente="Salerno";
			
			ps=con.prepareStatement(sql);
			ps.setString(1, param_cliente);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String nome=rs.getString("nome");
				String cognome=rs.getString("cognome");
				System.out.printf("%s %s \n", nome,cognome);
			}
		}catch(SQLException e) {
				System.err.println(e.getMessage());
			} finally { 
				try { 
					if(rs !=null) rs.close();
					if(ps!=null) ps.close();
					ConnectionPool.releaseConnection(con);
				} catch(SQLException e) {
					System.err.println(e.getMessage());
					}	
				}	
			}
	public void ricercaProdottoMagazzino() {
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			
			String sql="SELECT p.nome ,p.codice FROM risiede AS r,prodotto AS p WHERE p.genere=? AND r.IDmagazzino=? AND p.codice=r.codice;";
			String param_genere="smartphone";
			int param_IDm=1;
			ps=con.prepareStatement(sql);
			ps.setString(1,param_genere);
			ps.setInt(2, param_IDm);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String nome=rs.getString("nome");
				String codice=rs.getString("codice");
				System.out.printf("%s %s \n",nome,codice);
			}
			
		}catch(SQLException e) {
		System.err.println(e.getMessage());
	} finally { 
		try { 
			if(rs !=null) rs.close();
			if(ps!=null) ps.close();
			ConnectionPool.releaseConnection(con);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			}	
		}	
	}
		
	public void ricercaOrdine() {
		
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			
			String sql="SELECT numeroOrdine FROM ordine WHERE email=? AND statoDiElaborazione=?";
			String param_Ordine="gabrieletuozzo@gmail.com";
			String param_stato="IN LAVORAZIONE";
			ps=con.prepareStatement(sql);
			ps.setString(1, param_Ordine);
			ps.setString(2, param_stato);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String numeroOrdine=rs.getString(1);
				System.out.printf("%s \n", numeroOrdine);
				
			}
		
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		} finally { 
			try { 
				if(rs !=null) rs.close();
				if(ps!=null) ps.close();
				ConnectionPool.releaseConnection(con);
			} catch(SQLException e) {
				System.err.println(e.getMessage());
				}	
			}	
		}
	
	public void ricercaDisponibilitàPr() {
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
	
			String sql=" SELECT r.codice,p.nome,r.disponibilità,r.idMagazzino FROM prodotto AS p, risiede AS r WHERE r.codice=p.codice";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			System.out.println("\n Codice   Nome   (Disponibilità)   IDmagazzino \n");
			while(rs.next()) {
				String codice=rs.getString("codice");
				String nome=rs.getString("nome");
				String disponibilità=rs.getString("disponibilità");
				String idMagazzino=rs.getString("IDmagazzino");
				System.out.printf("%s %s (%s) %s \n", codice,nome,disponibilità,idMagazzino);
			}
		}catch(SQLException e) {
		System.err.println(e.getMessage());
	} finally { 
		try { 
			if(rs !=null) rs.close();
			if(ps!=null) ps.close();
			ConnectionPool.releaseConnection(con);
		} catch(SQLException e) {
			System.err.println(e.getMessage());
			}	
		}	
	}
	
	public void ricercaOrdineMax() {
		
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			
			String sql="SELECT numeroOrdine FROM ordine WHERE importoOrdine=(SELECT MAX(importoOrdine)FROM ordine)";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String numeroOrdine=rs.getString("numeroOrdine");
				System.out.printf("%s \n", numeroOrdine);
			}
		
		
		}catch(SQLException e) {
	System.err.println(e.getMessage());
		} finally { 
			try { 
				if(rs !=null) rs.close();
				if(ps!=null) ps.close();
				ConnectionPool.releaseConnection(con);
	} catch(SQLException e) {
		System.err.println(e.getMessage());
		}	
	}	
}

	public void prodottoPrezzoMax(){
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			
			String sql="SELECT nome FROM prodotto WHERE prezzo>ALL(SELECT prezzo FROM prodotto WHERE genere='componentistica pc')";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				String nome=rs.getString("nome");
				System.out.printf("%s \n",nome);
			}
		}catch(SQLException e) {
		System.err.println(e.getMessage());
	} finally { 
		try { 
			if(rs !=null) rs.close();
			if(ps!=null) ps.close();
			ConnectionPool.releaseConnection(con);
} catch(SQLException e) {
	System.err.println(e.getMessage());
	}	
}	
}
	
	public void deletePr() {
		Connection con= null;
		Statement st= null;
		ResultSet rs=null;
		
		try {
			con = ConnectionPool.getConnection();
			st=con.createStatement();
			int result=st.executeUpdate("DELETE FROM prodotto WHERE codice='BX80684I39100F'");
			if (result > 0) {
				System.out.println("Cancellazione effettuata");
				con.commit();
			} else {
				System.out.println("impossibile cancellare il/i record, prodotto non presente");
			}
		}catch(SQLException e) {
		System.err.println(e.getMessage());
	} finally { 
		try { 
			if(rs !=null) rs.close();
			if(st!=null) st.close();
			ConnectionPool.releaseConnection(con);
		} catch(SQLException e) {
	System.err.println(e.getMessage());
			}	
	
	}
	}
}
	