
package org.example.ws_ht;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.ws_ht package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ExcludedOwners_QNAME = new QName("http://www.example.org/WS-HT", "excludedOwners");
    private final static QName _Users_QNAME = new QName("http://www.example.org/WS-HT", "users");
    private final static QName _TaskStakeholders_QNAME = new QName("http://www.example.org/WS-HT", "taskStakeholders");
    private final static QName _BusinessAdministrators_QNAME = new QName("http://www.example.org/WS-HT", "businessAdministrators");
    private final static QName _LogicalPeopleGroups_QNAME = new QName("http://www.example.org/WS-HT", "logicalPeopleGroups");
    private final static QName _Priority_QNAME = new QName("http://www.example.org/WS-HT", "priority");
    private final static QName _Notification_QNAME = new QName("http://www.example.org/WS-HT", "notification");
    private final static QName _Import_QNAME = new QName("http://www.example.org/WS-HT", "import");
    private final static QName _OrganizationalEntity_QNAME = new QName("http://www.example.org/WS-HT", "organizationalEntity");
    private final static QName _Groups_QNAME = new QName("http://www.example.org/WS-HT", "groups");
    private final static QName _HumanInteractions_QNAME = new QName("http://www.example.org/WS-HT", "humanInteractions");
    private final static QName _Recipients_QNAME = new QName("http://www.example.org/WS-HT", "recipients");
    private final static QName _Task_QNAME = new QName("http://www.example.org/WS-HT", "task");
    private final static QName _Tasks_QNAME = new QName("http://www.example.org/WS-HT", "tasks");
    private final static QName _PotentialOwners_QNAME = new QName("http://www.example.org/WS-HT", "potentialOwners");
    private final static QName _Notifications_QNAME = new QName("http://www.example.org/WS-HT", "notifications");
    private final static QName _TaskInitiator_QNAME = new QName("http://www.example.org/WS-HT", "taskInitiator");
    private final static QName _DeadlinesInfo_QNAME = new QName("http://www.example.org/WS-HT", "deadlinesInfo");
    private final static QName _PeopleAssignments_QNAME = new QName("http://www.example.org/WS-HT", "peopleAssignments");
    private final static QName _User_QNAME = new QName("http://www.example.org/WS-HT", "user");
    private final static QName _Group_QNAME = new QName("http://www.example.org/WS-HT", "group");
    private final static QName _TExtensibleMixedContentElementsDocumentation_QNAME = new QName("http://www.example.org/WS-HT", "documentation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.ws_ht
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TExpression }
     * 
     */
    public TExpression createTExpression() {
        return new TExpression();
    }

    /**
     * Create an instance of {@link TExtensibleMixedContentElements }
     * 
     */
    public TExtensibleMixedContentElements createTExtensibleMixedContentElements() {
        return new TExtensibleMixedContentElements();
    }

    /**
     * Create an instance of {@link TLiteral }
     * 
     */
    public TLiteral createTLiteral() {
        return new TLiteral();
    }

    /**
     * Create an instance of {@link TDescription }
     * 
     */
    public TDescription createTDescription() {
        return new TDescription();
    }

    /**
     * Create an instance of {@link TDeadlineExpr }
     * 
     */
    public TDeadlineExpr createTDeadlineExpr() {
        return new TDeadlineExpr();
    }

    /**
     * Create an instance of {@link TOrganizationalEntity }
     * 
     */
    public TOrganizationalEntity createTOrganizationalEntity() {
        return new TOrganizationalEntity();
    }

    /**
     * Create an instance of {@link TBooleanExpr }
     * 
     */
    public TBooleanExpr createTBooleanExpr() {
        return new TBooleanExpr();
    }

    /**
     * Create an instance of {@link TToPart }
     * 
     */
    public TToPart createTToPart() {
        return new TToPart();
    }

    /**
     * Create an instance of {@link TToParts }
     * 
     */
    public TToParts createTToParts() {
        return new TToParts();
    }

    /**
     * Create an instance of {@link TDocumentation }
     * 
     */
    public TDocumentation createTDocumentation() {
        return new TDocumentation();
    }

    /**
     * Create an instance of {@link TLogicalPeopleGroup }
     * 
     */
    public TLogicalPeopleGroup createTLogicalPeopleGroup() {
        return new TLogicalPeopleGroup();
    }

    /**
     * Create an instance of {@link TDeadlinesInfo }
     * 
     */
    public TDeadlinesInfo createTDeadlinesInfo() {
        return new TDeadlinesInfo();
    }

    /**
     * Create an instance of {@link TTaskInterface }
     * 
     */
    public TTaskInterface createTTaskInterface() {
        return new TTaskInterface();
    }

    /**
     * Create an instance of {@link TTask }
     * 
     */
    public TTask createTTask() {
        return new TTask();
    }

    /**
     * Create an instance of {@link TPresentationElements }
     * 
     */
    public TPresentationElements createTPresentationElements() {
        return new TPresentationElements();
    }

    /**
     * Create an instance of {@link TPresentationParameter }
     * 
     */
    public TPresentationParameter createTPresentationParameter() {
        return new TPresentationParameter();
    }

    /**
     * Create an instance of {@link TLogicalPeopleGroups }
     * 
     */
    public TLogicalPeopleGroups createTLogicalPeopleGroups() {
        return new TLogicalPeopleGroups();
    }

    /**
     * Create an instance of {@link TExtensibleElements }
     * 
     */
    public TExtensibleElements createTExtensibleElements() {
        return new TExtensibleElements();
    }

    /**
     * Create an instance of {@link TReassignment }
     * 
     */
    public TReassignment createTReassignment() {
        return new TReassignment();
    }

    /**
     * Create an instance of {@link TDeadlineInfo }
     * 
     */
    public TDeadlineInfo createTDeadlineInfo() {
        return new TDeadlineInfo();
    }

    /**
     * Create an instance of {@link TRenderings }
     * 
     */
    public TRenderings createTRenderings() {
        return new TRenderings();
    }

    /**
     * Create an instance of {@link TDeadlines }
     * 
     */
    public TDeadlines createTDeadlines() {
        return new TDeadlines();
    }

    /**
     * Create an instance of {@link TPriority }
     * 
     */
    public TPriority createTPriority() {
        return new TPriority();
    }

    /**
     * Create an instance of {@link TNotificationInterface }
     * 
     */
    public TNotificationInterface createTNotificationInterface() {
        return new TNotificationInterface();
    }

    /**
     * Create an instance of {@link TDelegation }
     * 
     */
    public TDelegation createTDelegation() {
        return new TDelegation();
    }

    /**
     * Create an instance of {@link TTasks }
     * 
     */
    public TTasks createTTasks() {
        return new TTasks();
    }

    /**
     * Create an instance of {@link TRendering }
     * 
     */
    public TRendering createTRendering() {
        return new TRendering();
    }

    /**
     * Create an instance of {@link TDurationExpr }
     * 
     */
    public TDurationExpr createTDurationExpr() {
        return new TDurationExpr();
    }

    /**
     * Create an instance of {@link TImport }
     * 
     */
    public TImport createTImport() {
        return new TImport();
    }

    /**
     * Create an instance of {@link THumanInteractions }
     * 
     */
    public THumanInteractions createTHumanInteractions() {
        return new THumanInteractions();
    }

    /**
     * Create an instance of {@link TSavingTaskHistory }
     * 
     */
    public TSavingTaskHistory createTSavingTaskHistory() {
        return new TSavingTaskHistory();
    }

    /**
     * Create an instance of {@link TNotifications }
     * 
     */
    public TNotifications createTNotifications() {
        return new TNotifications();
    }

    /**
     * Create an instance of {@link TPresentationParameters }
     * 
     */
    public TPresentationParameters createTPresentationParameters() {
        return new TPresentationParameters();
    }

    /**
     * Create an instance of {@link TFrom }
     * 
     */
    public TFrom createTFrom() {
        return new TFrom();
    }

    /**
     * Create an instance of {@link TPeopleAssignments }
     * 
     */
    public TPeopleAssignments createTPeopleAssignments() {
        return new TPeopleAssignments();
    }

    /**
     * Create an instance of {@link TGenericHumanRole }
     * 
     */
    public TGenericHumanRole createTGenericHumanRole() {
        return new TGenericHumanRole();
    }

    /**
     * Create an instance of {@link TGrouplist }
     * 
     */
    public TGrouplist createTGrouplist() {
        return new TGrouplist();
    }

    /**
     * Create an instance of {@link TLocalNotification }
     * 
     */
    public TLocalNotification createTLocalNotification() {
        return new TLocalNotification();
    }

    /**
     * Create an instance of {@link TArgument }
     * 
     */
    public TArgument createTArgument() {
        return new TArgument();
    }

    /**
     * Create an instance of {@link TQuery }
     * 
     */
    public TQuery createTQuery() {
        return new TQuery();
    }

    /**
     * Create an instance of {@link TExtensions }
     * 
     */
    public TExtensions createTExtensions() {
        return new TExtensions();
    }

    /**
     * Create an instance of {@link TUserlist }
     * 
     */
    public TUserlist createTUserlist() {
        return new TUserlist();
    }

    /**
     * Create an instance of {@link TText }
     * 
     */
    public TText createTText() {
        return new TText();
    }

    /**
     * Create an instance of {@link TExtension }
     * 
     */
    public TExtension createTExtension() {
        return new TExtension();
    }

    /**
     * Create an instance of {@link TNotification }
     * 
     */
    public TNotification createTNotification() {
        return new TNotification();
    }

    /**
     * Create an instance of {@link TEscalation }
     * 
     */
    public TEscalation createTEscalation() {
        return new TEscalation();
    }

    /**
     * Create an instance of {@link TDeadline }
     * 
     */
    public TDeadline createTDeadline() {
        return new TDeadline();
    }

    /**
     * Create an instance of {@link TParameter }
     * 
     */
    public TParameter createTParameter() {
        return new TParameter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "excludedOwners")
    public JAXBElement<TGenericHumanRole> createExcludedOwners(TGenericHumanRole value) {
        return new JAXBElement<TGenericHumanRole>(_ExcludedOwners_QNAME, TGenericHumanRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TUserlist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "users")
    public JAXBElement<TUserlist> createUsers(TUserlist value) {
        return new JAXBElement<TUserlist>(_Users_QNAME, TUserlist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "taskStakeholders")
    public JAXBElement<TGenericHumanRole> createTaskStakeholders(TGenericHumanRole value) {
        return new JAXBElement<TGenericHumanRole>(_TaskStakeholders_QNAME, TGenericHumanRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "businessAdministrators")
    public JAXBElement<TGenericHumanRole> createBusinessAdministrators(TGenericHumanRole value) {
        return new JAXBElement<TGenericHumanRole>(_BusinessAdministrators_QNAME, TGenericHumanRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TLogicalPeopleGroups }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "logicalPeopleGroups")
    public JAXBElement<TLogicalPeopleGroups> createLogicalPeopleGroups(TLogicalPeopleGroups value) {
        return new JAXBElement<TLogicalPeopleGroups>(_LogicalPeopleGroups_QNAME, TLogicalPeopleGroups.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPriority }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "priority")
    public JAXBElement<TPriority> createPriority(TPriority value) {
        return new JAXBElement<TPriority>(_Priority_QNAME, TPriority.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TNotification }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "notification")
    public JAXBElement<TNotification> createNotification(TNotification value) {
        return new JAXBElement<TNotification>(_Notification_QNAME, TNotification.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TImport }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "import")
    public JAXBElement<TImport> createImport(TImport value) {
        return new JAXBElement<TImport>(_Import_QNAME, TImport.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "organizationalEntity")
    public JAXBElement<TOrganizationalEntity> createOrganizationalEntity(TOrganizationalEntity value) {
        return new JAXBElement<TOrganizationalEntity>(_OrganizationalEntity_QNAME, TOrganizationalEntity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TGrouplist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "groups")
    public JAXBElement<TGrouplist> createGroups(TGrouplist value) {
        return new JAXBElement<TGrouplist>(_Groups_QNAME, TGrouplist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link THumanInteractions }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "humanInteractions")
    public JAXBElement<THumanInteractions> createHumanInteractions(THumanInteractions value) {
        return new JAXBElement<THumanInteractions>(_HumanInteractions_QNAME, THumanInteractions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "recipients")
    public JAXBElement<TGenericHumanRole> createRecipients(TGenericHumanRole value) {
        return new JAXBElement<TGenericHumanRole>(_Recipients_QNAME, TGenericHumanRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "task")
    public JAXBElement<TTask> createTask(TTask value) {
        return new JAXBElement<TTask>(_Task_QNAME, TTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTasks }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "tasks")
    public JAXBElement<TTasks> createTasks(TTasks value) {
        return new JAXBElement<TTasks>(_Tasks_QNAME, TTasks.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "potentialOwners")
    public JAXBElement<TGenericHumanRole> createPotentialOwners(TGenericHumanRole value) {
        return new JAXBElement<TGenericHumanRole>(_PotentialOwners_QNAME, TGenericHumanRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TNotifications }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "notifications")
    public JAXBElement<TNotifications> createNotifications(TNotifications value) {
        return new JAXBElement<TNotifications>(_Notifications_QNAME, TNotifications.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TGenericHumanRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "taskInitiator")
    public JAXBElement<TGenericHumanRole> createTaskInitiator(TGenericHumanRole value) {
        return new JAXBElement<TGenericHumanRole>(_TaskInitiator_QNAME, TGenericHumanRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDeadlinesInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "deadlinesInfo")
    public JAXBElement<TDeadlinesInfo> createDeadlinesInfo(TDeadlinesInfo value) {
        return new JAXBElement<TDeadlinesInfo>(_DeadlinesInfo_QNAME, TDeadlinesInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TPeopleAssignments }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "peopleAssignments")
    public JAXBElement<TPeopleAssignments> createPeopleAssignments(TPeopleAssignments value) {
        return new JAXBElement<TPeopleAssignments>(_PeopleAssignments_QNAME, TPeopleAssignments.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "user")
    public JAXBElement<String> createUser(String value) {
        return new JAXBElement<String>(_User_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "group")
    public JAXBElement<String> createGroup(String value) {
        return new JAXBElement<String>(_Group_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TDocumentation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT", name = "documentation", scope = TExtensibleMixedContentElements.class)
    public JAXBElement<TDocumentation> createTExtensibleMixedContentElementsDocumentation(TDocumentation value) {
        return new JAXBElement<TDocumentation>(_TExtensibleMixedContentElementsDocumentation_QNAME, TDocumentation.class, TExtensibleMixedContentElements.class, value);
    }

}
