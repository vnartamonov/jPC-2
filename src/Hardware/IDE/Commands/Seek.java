/*
 * Copyright (C) 2017 h0MER247
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package Hardware.IDE.Commands;

import static Hardware.IDE.ATARegister.ATA_SR_DSC;



public final class Seek extends ATACommand {

    @Override
    public boolean onFirstExecute() {
        
        return proceed();
    }

    @Override
    public void onExecute() {
        
        m_drive.getRegister().status |= ATA_SR_DSC;
        m_drive.requestIRQ();
    }

    @Override
    public void onPIOBufferEvent() {
    }
}