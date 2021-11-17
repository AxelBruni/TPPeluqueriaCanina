package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Mascota;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author axelb
 */
public class MascotaJpaController implements Serializable {

    public MascotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public MascotaJpaController() {
        emf = Persistence.createEntityManagerFactory("TPPeluqueriaCaninaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mascota mascotaClie) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mascotaClie);
            em.flush();
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mascota mascotaClie) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mascotaClie = em.merge(mascotaClie);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mascotaClie.getNumCliente();
                if (findMascotaClie(id) == null) {
                    throw new NonexistentEntityException("The mascotaClie with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mascota mascotaClie;
            try {
                mascotaClie = em.getReference(Mascota.class, id);
                mascotaClie.getNumCliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mascotaClie with id " + id + " no longer exists.", enfe);
            }
            em.remove(mascotaClie);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mascota> findMascotaClieEntities() {
        return findMascotaClieEntities(true, -1, -1);
    }

    public List<Mascota> findMascotaClieEntities(int maxResults, int firstResult) {
        return findMascotaClieEntities(false, maxResults, firstResult);
    }

    private List<Mascota> findMascotaClieEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mascota.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Mascota findMascotaClie(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mascota.class, id);
        } finally {
            em.close();
        }
    }

    public int getMascotaClieCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mascota> rt = cq.from(Mascota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
