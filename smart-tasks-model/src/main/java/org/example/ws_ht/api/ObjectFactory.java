
package org.example.ws_ht.api;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.example.ws_ht.TOrganizationalEntity;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.example.ws_ht.api package. 
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

    private final static QName _TaskAbstract_QNAME = new QName("http://www.example.org/WS-HT/api", "taskAbstract");
    private final static QName _Comment_QNAME = new QName("http://www.example.org/WS-HT/api", "comment");
    private final static QName _Task_QNAME = new QName("http://www.example.org/WS-HT/api", "task");
    private final static QName _AttachmentInfo_QNAME = new QName("http://www.example.org/WS-HT/api", "attachmentInfo");
    private final static QName _Attachment_QNAME = new QName("http://www.example.org/WS-HT/api", "attachment");
    private final static QName _TaskQueryResultSet_QNAME = new QName("http://www.example.org/WS-HT/api", "taskQueryResultSet");
    private final static QName _TTaskQueryResultRowCreatedOn_QNAME = new QName("http://www.example.org/WS-HT/api", "createdOn");
    private final static QName _TTaskQueryResultRowPresentationDescription_QNAME = new QName("http://www.example.org/WS-HT/api", "presentationDescription");
    private final static QName _TTaskQueryResultRowStartByExists_QNAME = new QName("http://www.example.org/WS-HT/api", "startByExists");
    private final static QName _TTaskQueryResultRowTaskInitiator_QNAME = new QName("http://www.example.org/WS-HT/api", "taskInitiator");
    private final static QName _TTaskQueryResultRowExpirationTime_QNAME = new QName("http://www.example.org/WS-HT/api", "expirationTime");
    private final static QName _TTaskQueryResultRowEscalated_QNAME = new QName("http://www.example.org/WS-HT/api", "escalated");
    private final static QName _TTaskQueryResultRowCreatedBy_QNAME = new QName("http://www.example.org/WS-HT/api", "createdBy");
    private final static QName _TTaskQueryResultRowHasAttachments_QNAME = new QName("http://www.example.org/WS-HT/api", "hasAttachments");
    private final static QName _TTaskQueryResultRowCompleteByExists_QNAME = new QName("http://www.example.org/WS-HT/api", "completeByExists");
    private final static QName _TTaskQueryResultRowRenderingMethodExists_QNAME = new QName("http://www.example.org/WS-HT/api", "renderingMethodExists");
    private final static QName _TTaskQueryResultRowIsSkipable_QNAME = new QName("http://www.example.org/WS-HT/api", "isSkipable");
    private final static QName _TTaskQueryResultRowActualOwner_QNAME = new QName("http://www.example.org/WS-HT/api", "actualOwner");
    private final static QName _TTaskQueryResultRowStatus_QNAME = new QName("http://www.example.org/WS-HT/api", "status");
    private final static QName _TTaskQueryResultRowPrimarySearchBy_QNAME = new QName("http://www.example.org/WS-HT/api", "primarySearchBy");
    private final static QName _TTaskQueryResultRowPotentialOwners_QNAME = new QName("http://www.example.org/WS-HT/api", "potentialOwners");
    private final static QName _TTaskQueryResultRowHasPotentialOwners_QNAME = new QName("http://www.example.org/WS-HT/api", "hasPotentialOwners");
    private final static QName _TTaskQueryResultRowHasFault_QNAME = new QName("http://www.example.org/WS-HT/api", "hasFault");
    private final static QName _TTaskQueryResultRowId_QNAME = new QName("http://www.example.org/WS-HT/api", "id");
    private final static QName _TTaskQueryResultRowName_QNAME = new QName("http://www.example.org/WS-HT/api", "name");
    private final static QName _TTaskQueryResultRowActivationTime_QNAME = new QName("http://www.example.org/WS-HT/api", "activationTime");
    private final static QName _TTaskQueryResultRowPriority_QNAME = new QName("http://www.example.org/WS-HT/api", "priority");
    private final static QName _TTaskQueryResultRowPresentationSubject_QNAME = new QName("http://www.example.org/WS-HT/api", "presentationSubject");
    private final static QName _TTaskQueryResultRowHasComments_QNAME = new QName("http://www.example.org/WS-HT/api", "hasComments");
    private final static QName _TTaskQueryResultRowPresentationName_QNAME = new QName("http://www.example.org/WS-HT/api", "presentationName");
    private final static QName _TTaskQueryResultRowNotificationRecipients_QNAME = new QName("http://www.example.org/WS-HT/api", "notificationRecipients");
    private final static QName _TTaskQueryResultRowHasOutput_QNAME = new QName("http://www.example.org/WS-HT/api", "hasOutput");
    private final static QName _TTaskQueryResultRowTaskType_QNAME = new QName("http://www.example.org/WS-HT/api", "taskType");
    private final static QName _TTaskQueryResultRowTaskStakeholders_QNAME = new QName("http://www.example.org/WS-HT/api", "taskStakeholders");
    private final static QName _TTaskQueryResultRowBusinessAdministrators_QNAME = new QName("http://www.example.org/WS-HT/api", "businessAdministrators");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.example.ws_ht.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TTaskQueryResultSet }
     * 
     */
    public TTaskQueryResultSet createTTaskQueryResultSet() {
        return new TTaskQueryResultSet();
    }

    /**
     * Create an instance of {@link TAttachmentInfo }
     * 
     */
    public TAttachmentInfo createTAttachmentInfo() {
        return new TAttachmentInfo();
    }

    /**
     * Create an instance of {@link TComment }
     * 
     */
    public TComment createTComment() {
        return new TComment();
    }

    /**
     * Create an instance of {@link TTaskAbstract }
     * 
     */
    public TTaskAbstract createTTaskAbstract() {
        return new TTaskAbstract();
    }

    /**
     * Create an instance of {@link TAttachment }
     * 
     */
    public TAttachment createTAttachment() {
        return new TAttachment();
    }

    /**
     * Create an instance of {@link TTask }
     * 
     */
    public TTask createTTask() {
        return new TTask();
    }

    /**
     * Create an instance of {@link TTaskQueryResultRow }
     * 
     */
    public TTaskQueryResultRow createTTaskQueryResultRow() {
        return new TTaskQueryResultRow();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTaskAbstract }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "taskAbstract")
    public JAXBElement<TTaskAbstract> createTaskAbstract(TTaskAbstract value) {
        return new JAXBElement<TTaskAbstract>(_TaskAbstract_QNAME, TTaskAbstract.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TComment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "comment")
    public JAXBElement<TComment> createComment(TComment value) {
        return new JAXBElement<TComment>(_Comment_QNAME, TComment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTask }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "task")
    public JAXBElement<TTask> createTask(TTask value) {
        return new JAXBElement<TTask>(_Task_QNAME, TTask.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAttachmentInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "attachmentInfo")
    public JAXBElement<TAttachmentInfo> createAttachmentInfo(TAttachmentInfo value) {
        return new JAXBElement<TAttachmentInfo>(_AttachmentInfo_QNAME, TAttachmentInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TAttachment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "attachment")
    public JAXBElement<TAttachment> createAttachment(TAttachment value) {
        return new JAXBElement<TAttachment>(_Attachment_QNAME, TAttachment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TTaskQueryResultSet }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "taskQueryResultSet")
    public JAXBElement<TTaskQueryResultSet> createTaskQueryResultSet(TTaskQueryResultSet value) {
        return new JAXBElement<TTaskQueryResultSet>(_TaskQueryResultSet_QNAME, TTaskQueryResultSet.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "createdOn", scope = TTaskQueryResultRow.class)
    public JAXBElement<XMLGregorianCalendar> createTTaskQueryResultRowCreatedOn(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TTaskQueryResultRowCreatedOn_QNAME, XMLGregorianCalendar.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "presentationDescription", scope = TTaskQueryResultRow.class)
    public JAXBElement<String> createTTaskQueryResultRowPresentationDescription(String value) {
        return new JAXBElement<String>(_TTaskQueryResultRowPresentationDescription_QNAME, String.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "startByExists", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowStartByExists(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowStartByExists_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "taskInitiator", scope = TTaskQueryResultRow.class)
    public JAXBElement<TOrganizationalEntity> createTTaskQueryResultRowTaskInitiator(TOrganizationalEntity value) {
        return new JAXBElement<TOrganizationalEntity>(_TTaskQueryResultRowTaskInitiator_QNAME, TOrganizationalEntity.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "expirationTime", scope = TTaskQueryResultRow.class)
    public JAXBElement<XMLGregorianCalendar> createTTaskQueryResultRowExpirationTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TTaskQueryResultRowExpirationTime_QNAME, XMLGregorianCalendar.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "escalated", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowEscalated(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowEscalated_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "createdBy", scope = TTaskQueryResultRow.class)
    public JAXBElement<String> createTTaskQueryResultRowCreatedBy(String value) {
        return new JAXBElement<String>(_TTaskQueryResultRowCreatedBy_QNAME, String.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "hasAttachments", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowHasAttachments(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowHasAttachments_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "completeByExists", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowCompleteByExists(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowCompleteByExists_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "renderingMethodExists", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowRenderingMethodExists(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowRenderingMethodExists_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "isSkipable", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowIsSkipable(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowIsSkipable_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "actualOwner", scope = TTaskQueryResultRow.class)
    public JAXBElement<String> createTTaskQueryResultRowActualOwner(String value) {
        return new JAXBElement<String>(_TTaskQueryResultRowActualOwner_QNAME, String.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "status", scope = TTaskQueryResultRow.class)
    public JAXBElement<TStatus> createTTaskQueryResultRowStatus(TStatus value) {
        return new JAXBElement<TStatus>(_TTaskQueryResultRowStatus_QNAME, TStatus.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "primarySearchBy", scope = TTaskQueryResultRow.class)
    public JAXBElement<String> createTTaskQueryResultRowPrimarySearchBy(String value) {
        return new JAXBElement<String>(_TTaskQueryResultRowPrimarySearchBy_QNAME, String.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "potentialOwners", scope = TTaskQueryResultRow.class)
    public JAXBElement<TOrganizationalEntity> createTTaskQueryResultRowPotentialOwners(TOrganizationalEntity value) {
        return new JAXBElement<TOrganizationalEntity>(_TTaskQueryResultRowPotentialOwners_QNAME, TOrganizationalEntity.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "hasPotentialOwners", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowHasPotentialOwners(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowHasPotentialOwners_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "hasFault", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowHasFault(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowHasFault_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "id", scope = TTaskQueryResultRow.class)
    public JAXBElement<String> createTTaskQueryResultRowId(String value) {
        return new JAXBElement<String>(_TTaskQueryResultRowId_QNAME, String.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "name", scope = TTaskQueryResultRow.class)
    public JAXBElement<QName> createTTaskQueryResultRowName(QName value) {
        return new JAXBElement<QName>(_TTaskQueryResultRowName_QNAME, QName.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "activationTime", scope = TTaskQueryResultRow.class)
    public JAXBElement<XMLGregorianCalendar> createTTaskQueryResultRowActivationTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TTaskQueryResultRowActivationTime_QNAME, XMLGregorianCalendar.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "priority", scope = TTaskQueryResultRow.class)
    public JAXBElement<BigInteger> createTTaskQueryResultRowPriority(BigInteger value) {
        return new JAXBElement<BigInteger>(_TTaskQueryResultRowPriority_QNAME, BigInteger.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "presentationSubject", scope = TTaskQueryResultRow.class)
    public JAXBElement<String> createTTaskQueryResultRowPresentationSubject(String value) {
        return new JAXBElement<String>(_TTaskQueryResultRowPresentationSubject_QNAME, String.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "hasComments", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowHasComments(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowHasComments_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "presentationName", scope = TTaskQueryResultRow.class)
    public JAXBElement<String> createTTaskQueryResultRowPresentationName(String value) {
        return new JAXBElement<String>(_TTaskQueryResultRowPresentationName_QNAME, String.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "notificationRecipients", scope = TTaskQueryResultRow.class)
    public JAXBElement<TOrganizationalEntity> createTTaskQueryResultRowNotificationRecipients(TOrganizationalEntity value) {
        return new JAXBElement<TOrganizationalEntity>(_TTaskQueryResultRowNotificationRecipients_QNAME, TOrganizationalEntity.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "hasOutput", scope = TTaskQueryResultRow.class)
    public JAXBElement<Boolean> createTTaskQueryResultRowHasOutput(Boolean value) {
        return new JAXBElement<Boolean>(_TTaskQueryResultRowHasOutput_QNAME, Boolean.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "taskType", scope = TTaskQueryResultRow.class)
    public JAXBElement<String> createTTaskQueryResultRowTaskType(String value) {
        return new JAXBElement<String>(_TTaskQueryResultRowTaskType_QNAME, String.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "taskStakeholders", scope = TTaskQueryResultRow.class)
    public JAXBElement<TOrganizationalEntity> createTTaskQueryResultRowTaskStakeholders(TOrganizationalEntity value) {
        return new JAXBElement<TOrganizationalEntity>(_TTaskQueryResultRowTaskStakeholders_QNAME, TOrganizationalEntity.class, TTaskQueryResultRow.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TOrganizationalEntity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.example.org/WS-HT/api", name = "businessAdministrators", scope = TTaskQueryResultRow.class)
    public JAXBElement<TOrganizationalEntity> createTTaskQueryResultRowBusinessAdministrators(TOrganizationalEntity value) {
        return new JAXBElement<TOrganizationalEntity>(_TTaskQueryResultRowBusinessAdministrators_QNAME, TOrganizationalEntity.class, TTaskQueryResultRow.class, value);
    }

}
