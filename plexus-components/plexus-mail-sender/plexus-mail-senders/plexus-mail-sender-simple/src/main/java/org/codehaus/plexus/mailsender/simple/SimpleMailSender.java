package org.codehaus.plexus.mailsender.simple;

/*
 * LICENSE
 */

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.codehaus.plexus.logging.AbstractLogEnabled;
import org.codehaus.plexus.mailsender.AbstractMailSender;
import org.codehaus.plexus.mailsender.MailSenderException;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;

/**
 * @author <a href="mailto:trygvis@inamo.no">Trygve Laugst&oslash;l</a>
 * @version $Id$
 */
public class SimpleMailSender
	extends AbstractMailSender
{
    // ----------------------------------------------------------------------
    // MailSender Implementation
    // ----------------------------------------------------------------------

    public void send() throws MailSenderException
	{
        try
        {
            MailMessage message = new MailMessage( getSmtpHost(), getSmtpPort() );

            message.from( makeEmailAddress( getFromAddress(), getFromName() ) );

            for( Iterator iter = getToAddresses().keySet().iterator(); iter.hasNext(); )
            {
                String toAddress = (String) iter.next();
                String toName = (String) getToAddresses().get( toAddress );
                message.to( makeEmailAddress( toAddress, toName ) );
            }

            for( Iterator iter = getCcAddresses().keySet().iterator(); iter.hasNext(); )
            {
                String ccAddress = (String) iter.next();
                String ccName = (String) getCcAddresses().get( ccAddress );
                message.cc( makeEmailAddress( ccAddress, ccName ) );
            }

            for( Iterator iter = getBccAddresses().keySet().iterator(); iter.hasNext(); )
            {
                String bccAddress = (String) iter.next();
                String bccName = (String) getBccAddresses().get( bccAddress );
                message.bcc( makeEmailAddress( bccAddress, bccName ) );
            }

            message.setSubject( getSubject() );

            for ( Iterator it = getHeaders().entrySet().iterator(); it.hasNext(); )
            {
                Map.Entry entry = (Map.Entry) it.next();

                message.setHeader( entry.getKey().toString(), entry.getValue().toString() );
            }

            message.setHeader( "Date", DateFormatUtils.getDateHeader( new Date() ) );

            message.getPrintStream().print( getContent() );

            message.sendAndClose();
        }
        catch( IOException ex )
        {
            throw new MailSenderException( "Error while sending mail.", ex );
        }
    }
}
