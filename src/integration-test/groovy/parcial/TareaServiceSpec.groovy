package parcial

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TareaServiceSpec extends Specification {

    TareaService tareaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Tarea(...).save(flush: true, failOnError: true)
        //new Tarea(...).save(flush: true, failOnError: true)
        //Tarea tarea = new Tarea(...).save(flush: true, failOnError: true)
        //new Tarea(...).save(flush: true, failOnError: true)
        //new Tarea(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //tarea.id
    }

    void "test get"() {
        setupData()

        expect:
        tareaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Tarea> tareaList = tareaService.list(max: 2, offset: 2)

        then:
        tareaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        tareaService.count() == 5
    }

    void "test delete"() {
        Long tareaId = setupData()

        expect:
        tareaService.count() == 5

        when:
        tareaService.delete(tareaId)
        sessionFactory.currentSession.flush()

        then:
        tareaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Tarea tarea = new Tarea()
        tareaService.save(tarea)

        then:
        tarea.id != null
    }
}
